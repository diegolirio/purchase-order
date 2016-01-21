package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Unidade do produto, Caixa, Unico ??? 
 * @author desenv
 *
 */
@Entity
public class ProductUnit {

	@Id @GeneratedValue
	private Long id;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductUnit [id=" + id + ", description=" + description + "]";
	}
	
	
	
}
