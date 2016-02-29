package com.diegolirio.purchaseorder.models;

import javax.persistence.Entity;

@Entity
public class Customer extends People {

	private String signUpState;
	
	public Customer() {
		
	}
	
	public Customer(Long id) {
		super.setId(id);
	}
	
	public String getSignUpState() {
		return signUpState;
	}
	public void setSignUpState(String signUpState) {
		this.signUpState = signUpState;
	}	


	public static Customer getNewInstance(Customer customer) {
		Customer c = new Customer();
		c.setCpfCnpj(customer.getCpfCnpj());
		c.setEmail(customer.getEmail());
		c.setName(customer.getName());
		c.setSignUpState(customer.getSignUpState());
		return c;
	}

	
	@Override
	public String toString() {
		return "Customer [signUpState=" + signUpState + ", toString()=" + super.toString() + "]";
	}
	





	
}
