package com.diegolirio.purchaseorder.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public abstract class People {

	@Id @GeneratedValue
	private Long id;
	
	private String cpfCnpj;
	
	private String name;
	
	@OneToMany(mappedBy="people")
	private List<Address> addresses;
	
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

	@Override
	public String toString() {
		return "People [id=" + id + ", cpfCnpj=" + cpfCnpj + ", name=" + name
				+ ", addresses=" + addresses + ", phones=" + phones + "]";
	}
	
	
	
	
}
