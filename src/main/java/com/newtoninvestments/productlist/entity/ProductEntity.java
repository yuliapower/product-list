package com.newtoninvestments.productlist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_product")
@NoArgsConstructor
public class ProductEntity extends AbstractAuditableEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "kcal")
    private Integer kcal;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductListEntity productList;
}
