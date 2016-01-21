package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;

@Entity
public class Client extends People {

	private String signUpState;
	
	public String getSignUpState() {
		return signUpState;
	}
	public void setSignUpState(String signUpState) {
		this.signUpState = signUpState;
	}
	
	
}
