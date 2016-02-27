package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.ProductType;
import com.diegolirio.purchaseorder.repositories.ProductTypeRepository;

@Service
public class ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	public Iterable<ProductType> getAll() {
		return this.productTypeRepository.findAll();
	}

}
