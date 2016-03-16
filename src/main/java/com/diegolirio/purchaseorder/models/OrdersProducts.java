package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdersProducts {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private PurchaseOrder purchaseOrder;
	
	private double valueUnit;
	private double amount; // qtde
	
	public OrdersProducts(){}
	
	public OrdersProducts(long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public PurchaseOrder getOrder() {
		return purchaseOrder;
	}
	public void setOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public double getValueUnit() {
		return valueUnit;
	}
	public void setValueUnit(double valueUnit) {
		this.valueUnit = valueUnit;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
