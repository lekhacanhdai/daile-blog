package com.blog.common.kafka.cdc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author daile
 * @since 08/06/2024
 */

@RequiredArgsConstructor
@Log4j2
public abstract class CdcEventConsumer<
        E,
        C extends BCdcObject<E>,
        R extends CrudRepository<E, UUID>> {
    private final ObjectMapper objectMapper;
    private final R repository;
    private final Class<C> cClass;

    protected abstract void onChange(ConsumerRecord<String, String> record);

    protected void onEvent(ConsumerRecord<String, String> record) {
        if (record.value() == null) {
            log.info("Received tombstone event for key {} from topic {}. Ignored", record.key(), record.topic());
            return;
        }
        try {
            var payload = objectMapper.readValue(record.value(), CdcPayload.class);
            process(payload);
        } catch (JsonProcessingException e) {
            log.info("Failure when convert cdc event from topic {}. {}", record.topic(), e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    protected void process(CdcPayload payload) {
        switch (payload.getOp()) {
            case CdcEventOp.UPDATE, CdcEventOp.CREATE, CdcEventOp.READ -> onUpsetHandler(payload);
            case CdcEventOp.DELETE -> onDeleteHandler(payload);
            default -> log.error("Can't not handler op {}", payload.getOp());
        }
    }

    protected void onUpsetHandler(CdcPayload payload) {
        var entity = objectMapper.convertValue(payload.getAfter(), cClass).toEntity();
        repository.save(entity);
    }
    protected void onDeleteHandler(CdcPayload payload) {
        var entity = objectMapper.convertValue(payload.getAfter(), cClass).toEntity();
        repository.delete(entity);
    }
}
