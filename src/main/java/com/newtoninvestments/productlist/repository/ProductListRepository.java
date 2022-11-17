package com.newtoninvestments.productlist.repository;

import com.newtoninvestments.productlist.entity.ProductListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductListRepository extends JpaRepository<ProductListEntity, Long> {

}
