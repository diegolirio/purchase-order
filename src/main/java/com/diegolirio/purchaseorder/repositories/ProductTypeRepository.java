package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

}
