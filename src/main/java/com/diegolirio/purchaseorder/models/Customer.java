package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;

@Entity
public class Customer extends People {

	private String signUpState;
	
	public Customer() {
		
	}
	
	public Customer(long id) {
		super.setId(id);
	}
	
	public String getSignUpState() {
		return signUpState;
	}
	public void setSignUpState(String signUpState) {
		this.signUpState = signUpState;
	}

	@Override
	public String toString() {
		return "Customer [signUpState=" + signUpState + ", toString()=" + super.toString() + "]";
	}





	
}
