package com.blog.account.domain.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author daile
 * @since 01/06/2024
 */
@Configuration
public class JpaQueryDslConfig {
  @Bean
  public JPAQueryFactory jpaQueryFactory(EntityManager ENTITYMANAGE) {
    return new JPAQueryFactory(ENTITYMANAGE);
  }
}
