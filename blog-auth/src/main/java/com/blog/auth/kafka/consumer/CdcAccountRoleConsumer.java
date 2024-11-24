package com.blog.auth.kafka.consumer;

import com.blog.auth.domain.entity.CdcRoleEntity;
import com.blog.auth.domain.repository.RoleRepository;
import com.blog.auth.kafka.payload.cdc.CdcRole;
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
public class CdcAccountRoleConsumer
    extends CdcEventConsumer<CdcRoleEntity, CdcRole, RoleRepository> {

  public CdcAccountRoleConsumer(ObjectMapper objectMapper, RoleRepository repository) {
    super(objectMapper, repository, CdcRole.class);
  }

  @Override
  @KafkaListener(
      topics = {"blogaccount.blogaccount.roles"},
      containerFactory = "kafkaListenerContainerFactory")
  protected void onChange(ConsumerRecord<String, String> record) {
    onEvent(record);
  }
}
