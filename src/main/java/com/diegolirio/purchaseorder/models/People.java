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
public abstract class People {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String cpfCnpj;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="people")
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToMany(mappedBy="people")
	private List<Telephone> phones;

	public People() { }

	public People(Long id) {
		this.id = id;
	}
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		People other = (People) obj;
		if(other.getId() == id)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", cpfCnpj=" + cpfCnpj + ", name=" + name + "]";
	}
	
	
	
	
}
