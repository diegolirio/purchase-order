package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Product;

@Repository
public interface ProductRepositorie extends CrudRepository<Product, Long> {

	public Product findByCode(String code);

	public List<Product> findByCodeContainingOrDescriptionContainingIgnoreCase(String code, String description);

}
