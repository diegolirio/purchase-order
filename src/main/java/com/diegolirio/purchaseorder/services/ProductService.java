package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.Product;
import com.diegolirio.purchaseorder.repositories.ProductRepositorie;

@Service
public class ProductService {

	@Autowired
	private ProductRepositorie productRepositorie;

	public List<Product> getAll() {
		return this.productRepositorie.findByActive(true);
	}

	/**
	 * utilizado somente para inserir, utilizado para cadastro rapido
	 * @param product
	 * @return Product
	 */
	public Product insert(Product product) {
		if(product.getId() != null && product.getId() > 0)
			throw new RuntimeException("Utilizado somente para criar um novo produto!");
		Product findByCode = this.productRepositorie.findByCodeAndActive(product.getCode(), true);
		if(findByCode != null) throw new RuntimeException("Já existe um produto com este Código");
		return this.productRepositorie.save(product);		
	}
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	public Product save(Product product) {
		if(product.getId() != null && product.getId() > 0) {
			// alterando
			Product p = Product.getNewInstance(product);
			this.delete(product);
			return this.productRepositorie.save(p);			
		}
		// criando um novo
		return this.insert(product);
	}

	/**
	 * Delete address if using desactive
	 * @param id
	 */
	public void delete(long id) {
		try {
			productRepositorie.delete(id);
		} catch(ConstraintViolationException|DataIntegrityViolationException cve) {
			Product p = this.productRepositorie.findOne(id);
			p.setActive(false);
			productRepositorie.save(p);
		}	
	}
	
	/**
	 * Delete address if using desactive
	 * @param address
	 */
	public void delete(Product product) {
		this.delete(product.getId());
	}
	
	
	public Product getByCode(String code) {
		return this.productRepositorie.findByCodeAndActive(code, true);
	}

	public List<Product> getByCodeOrDescription(String code, String description) {	
		return this.productRepositorie.findByCodeContainingOrDescriptionContainingAndActive(code, description, true);
	}

	public Product get(long id) {
		return this.productRepositorie.findOne(id);
	}

	public List<Product> findAdvanced(String fieldSearch) {
		return 
		   this
			.productRepositorie
			.findByCodeContainingOrDescriptionContainingAndActive(fieldSearch, fieldSearch, true);
	}

	
	
}
