package com.diegolirio.purchaseorder.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Product {

	@Id @GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String code;
	private String description;
	private double valueUnit;
	
	@ManyToOne
	private ProductType productType;
	
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<OrdersProducts> ordersProducts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValueUnit() {
		return valueUnit;
	}

	public void setValueUnit(double valueUnit) {
		this.valueUnit = valueUnit;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<OrdersProducts> getOrdersProducts() {
		return ordersProducts;
	}

	public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
		this.ordersProducts = ordersProducts;
	} 
	
	
}
