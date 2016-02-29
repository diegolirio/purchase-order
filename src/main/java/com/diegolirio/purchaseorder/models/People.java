package com.diegolirio.purchaseorder.models;

import java.util.List;

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
	
	private String cpfCnpj;
	
	private String name;
	
	private String email;

	private boolean active = true;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Telephone> getPhones() {
		return phones;
	}

	public void setPhones(List<Telephone> phones) {
		this.phones = phones;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", cpfCnpj=" + cpfCnpj + ", name=" + name
				+ "]";
	}

	
	
	
}
