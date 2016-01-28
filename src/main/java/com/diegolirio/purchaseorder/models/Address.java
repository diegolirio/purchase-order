package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id @GeneratedValue
	public Long id;
	
	public String cep;
	
	public String publicPlace; // logradouro
	public int number;
	public String neighborhood; // Bairro
	public String city;
	
	@ManyToOne
	public State state;
	
	@ManyToOne
	public People people;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", cep=" + cep + ", publicPlace="
				+ publicPlace + ", number=" + number + ", neighborhood="
				+ neighborhood + ", city=" + city + ", state=" + state
				+ ", people=" + people + "]";
	}

	
	
	

}
