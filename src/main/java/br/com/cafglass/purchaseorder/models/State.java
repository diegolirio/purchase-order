package br.com.cafglass.purchaseorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class State {

	@Id @GeneratedValue
	private Long id;
	
	private String abbreviation;
	
	private String name;
	
	public State() {
		super();
	}

	public State(String abbreviation, String name) {
		this();
		this.abbreviation = abbreviation;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
