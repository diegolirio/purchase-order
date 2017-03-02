package br.com.cafglass.purchaseorder.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id @GeneratedValue
	private Long id;
	
	private String code;
	private String description;
	private double valueUnit;
	
	@ManyToOne
	private ProductType productType;
	
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<OrdersProducts> ordersProducts;

	private boolean active = true;
	
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public static Product getNewInstance(Product product) {
		Product p = new Product();
		p.setActive(true);
		p.setCode(product.getCode());
		p.setDescription(product.getDescription());
		p.setProductType(product.getProductType());
		p.setValueUnit(product.getValueUnit());
		return p;
	} 
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description="
				+ description + ", valueUnit=" + valueUnit + ", productType="
				+ productType + "]";
	}

	
	
}
