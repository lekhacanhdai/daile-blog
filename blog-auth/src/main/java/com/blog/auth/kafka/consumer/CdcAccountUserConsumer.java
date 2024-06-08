package com.blog.auth.kafka.consumer;

import com.blog.auth.domain.entity.CdcUserEntity;
import com.blog.auth.domain.repository.UserRepository;
import com.blog.auth.kafka.payload.cdc.CdcUser;
import com.blog.common.kafka.cdc.CdcEventConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author daile
 * @since 08/06/2024
 */

@Component
public class CdcAccountUserConsumer extends CdcEventConsumer<CdcUserEntity, CdcUser, UserRepository> {
    public CdcAccountUserConsumer(ObjectMapper objectMapper, UserRepository repository) {
        super(objectMapper, repository, CdcUser.class);
    }

    @Override
    @KafkaListener(
            topics = {"blogaccount.blogaccount.users"},
            containerFactory = "kafkaListenerContainerFactory"
    )
    protected void onChange(ConsumerRecord<String, String> record) {
        onEvent(record);
    }
}
