package com.newtoninvestments.productlist.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class AbstractAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version")
    @Version
    protected Integer version;

    @Column(name = "created_at")
    @CreatedDate
    protected LocalDateTime createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    protected LocalDateTime modifiedAt;
}
