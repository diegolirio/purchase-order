package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Product;

@Repository
public interface ProductRepositorie extends CrudRepository<Product, Long> {

	public Product findByCodeAndActive(String code, boolean active);

	@Query("select p from Product p where (p.code like %?1% or p.description like %?2%) and p.active = ?3")
	public List<Product> findByCodeContainingOrDescriptionContainingAndActive(String code, String description, boolean active);

	public List<Product> findByActive(boolean active);

	@Query("from Product p order by p.code")
	public List<Product> findAllByOrderByCode();

}
