package com.blog.account.domain.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author daile
 * @since 26/05/2024
 */

@Getter
@Setter
public abstract class CommonEntity {
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    @Column(name = "modified_by")
    private UUID modifiedBy;

    public void preCreate(UUID userId){
        createdBy = userId;
        createdDate = new Timestamp(System.currentTimeMillis());
    }

    public void preModified(UUID userId){
        modifiedBy = userId;
        modifiedDate = new Timestamp(System.currentTimeMillis());
    }
}
