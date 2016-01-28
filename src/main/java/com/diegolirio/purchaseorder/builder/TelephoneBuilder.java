package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.People;
import com.diegolirio.purchaseorder.models.Telephone;

public class TelephoneBuilder {

	private Long id;
	private String contactType;
	private String number;
	private People people;

	public TelephoneBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public TelephoneBuilder withContactType(String contactType) {
		this.contactType = contactType;
		return this;
	}
	
	public TelephoneBuilder withNumber(String number) {
		this.number = number;
		return this;
	}
	
	public TelephoneBuilder withPeople(People people) {
		this.people = people;
		return this;
	}
	
	public Telephone build() {
		Telephone telephone = new Telephone();
		telephone.setId(id);
		telephone.setContactType(contactType);
		telephone.setNumber(number);
		telephone.setPeople(people);
		return telephone;
	}

}
