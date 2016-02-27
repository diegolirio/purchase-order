package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.Product;
import com.diegolirio.purchaseorder.repositories.ProductRepositorie;

@Service
public class ProductService {

	@Autowired
	private ProductRepositorie productRepositorie;

	public Iterable<Product> getAll() {
		return this.productRepositorie.findAll();
	}

	public Product save(Product product) {
		Product findByCode = this.productRepositorie.findByCode(product.getCode());
		if(findByCode != null) throw new RuntimeException("Já existe um produto com este Código");
		return this.productRepositorie.save(product);
	}

	public Product getByCode(String code) {
		return this.productRepositorie.findByCode(code);
	}

	public List<Product> getByCodeOrDescription(String code, String description) {
		return this.productRepositorie.findByCodeContainingOrDescriptionContainingIgnoreCase(code, description);
	}

	public Product get(long id) {
		return this.productRepositorie.findOne(id);
	}

	public List<Product> findAdvanced(String fieldSearch) {
		return 
		   this
			.productRepositorie
			.findByCodeContainingOrDescriptionContainingIgnoreCase(fieldSearch, fieldSearch);
	}

	
	
}
