package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id @GeneratedValue
	private Long id;
	
	private String cep;
	
	private String publicPlace; // logradouro
	private int number;
	private String neighborhood; // Bairro
	private String city;
	
	@ManyToOne
	private State state;
	
	@ManyToOne
	private People people;
	
	private boolean active = true;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public static Address getNewInstance(Address address) {
		Address a = new Address();
		a.setCep(address.getCep());
		a.setCity(address.getCity());
		a.setNeighborhood(address.getNeighborhood());
		a.setNumber(address.getNumber());
		a.setPeople(address.getPeople());
		a.setPublicPlace(address.getPublicPlace());
		a.setState(address.getState());
		return a;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", cep=" + cep + ", publicPlace="
				+ publicPlace + ", number=" + number + ", neighborhood="
				+ neighborhood + ", city=" + city + ", state=" + state
				+ ", people=" + people + "]";
	}

}
