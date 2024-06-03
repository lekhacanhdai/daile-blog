package com.blog.account.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author daile
 * @since 26/05/2024
 */

@Getter
@Setter
@MappedSuperclass
public abstract class CommonEntity<T> {
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "created_by")
    private T createdBy;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    @Column(name = "modified_by")
    private T modifiedBy;

    @PrePersist
    public void preCreate(){
        createdDate = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preModified(){
        modifiedDate = new Timestamp(System.currentTimeMillis());
    }
}
