package br.com.cafglass.purchaseorder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telephone {

	@Id @GeneratedValue
	private Long id;
	
	private String contactType; // Comercial | Casa | Celular

	private String number;
	
	@ManyToOne
	private People people;

	private boolean active = true;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
	
	public static Telephone getNewInstance(Telephone telephone) {
		Telephone t = new Telephone();
		t.setContactType(telephone.getContactType());
		t.setNumber(telephone.getNumber());
		t.setPeople(telephone.getPeople());
		return t;
	}

	
}
