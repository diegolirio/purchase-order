package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Product;

@Repository
public interface ProductRepositorie extends CrudRepository<Product, Long> {

}
