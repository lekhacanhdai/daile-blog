package com.blog.auth.kafka.consumer;

import com.blog.auth.domain.entity.CdcUserRoleEntity;
import com.blog.auth.domain.repository.UserRoleRepository;
import com.blog.auth.kafka.payload.cdc.CdcUserRole;
import com.blog.common.kafka.cdc.CdcEventConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author daile
 * @since 10/06/2024
 */

@Component
public class CdcAccountUserRoleConsumer extends CdcEventConsumer<CdcUserRoleEntity, CdcUserRole, UserRoleRepository> {
    public CdcAccountUserRoleConsumer(ObjectMapper objectMapper, UserRoleRepository repository) {
        super(objectMapper, repository, CdcUserRole.class);
    }

    @Override
    @KafkaListener(
            topics = {"blogaccount.blogaccount.user_role"},
            containerFactory = "kafkaListenerContainerFactory"
    )
    protected void onChange(ConsumerRecord<String, String> record) {
        onEvent(record);
    }
}
