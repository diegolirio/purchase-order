package com.diegolirio.purchaseorder.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class People {
	
	@Id @GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String cpfCnpj;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="people")
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToMany(mappedBy="people")
	private List<Telephone> phones;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", cpfCnpj=" + cpfCnpj + ", name=" + name
				+ "]";
	}

	
	
	
}
