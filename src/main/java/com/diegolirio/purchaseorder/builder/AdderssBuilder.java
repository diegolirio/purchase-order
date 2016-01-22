package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.People;
import com.diegolirio.purchaseorder.models.State;

public class AdderssBuilder {

	private String cep;
	private String city;
	private Long id;
	private String neighborhood;
	private int number;
	private People people;
	private String publicPlace;
	private State state;

	public AdderssBuilder withCep(String cep) {
		this.cep = cep;
		return this;
	}
	
	public AdderssBuilder withCity(String city) {
		this.city = city;
		return this;
	}
	
	public AdderssBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public AdderssBuilder withNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
		return this;
	}
	
	public AdderssBuilder withNumber(int number) {
		this.number = number;
		return this;
	}
	
	public AdderssBuilder withPeople(People people) {
		this.people = people;
		return this;
	}
	
	public AdderssBuilder withPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
		return this;
	}
	
	public AdderssBuilder withState(State state) {
		this.state = state;
		return this;
	}
	
	public Address build() {
		Address address = new Address();
		address.setCep(cep);
		address.setCity(city);
		address.setId(id);
		address.setNeighborhood(neighborhood);
		address.setNumber(number);
		address.setPeople(people);
		address.setPublicPlace(publicPlace);
		address.setState(state);
		return address ;
	}

}
