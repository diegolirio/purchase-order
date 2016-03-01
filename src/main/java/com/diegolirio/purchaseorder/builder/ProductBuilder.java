package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Product;

public class ProductBuilder {

	private String code;
	private String description;
	private double valueUnit;

	public ProductBuilder withCode(String code) {
		this.code = code;
		return this;
	}

	public ProductBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public ProductBuilder withValueUnit(double valueUnit) {
		this.valueUnit = valueUnit;
		return this;
	}

	public Product build() {
		Product p = new Product();
		p.setCode(code);
		p.setDescription(description);
		p.setValueUnit(valueUnit);
		return p;
	}

}
