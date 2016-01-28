package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;

@Entity
public class Customer extends People {

	private String signUpState;
	
	public Customer() {
		super();
	}
	
	public Customer(Long id) {
		super(id);
	}
	
	public String getSignUpState() {
		return signUpState;
	}
	public void setSignUpState(String signUpState) {
		this.signUpState = signUpState;
	}
	@Override
	public String toString() {
		return "Customer [signUpState=" + signUpState + ", getId()=" + getId()
				+ ", getCpfCnpj()=" + getCpfCnpj() + ", getName()=" + getName()
				+ ", getAddresses()=" + getAddresses() + ", getPhones()="
				+ getPhones() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
	
}
