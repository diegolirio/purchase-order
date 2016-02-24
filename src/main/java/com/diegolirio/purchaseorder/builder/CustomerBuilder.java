package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Customer;

public class CustomerBuilder {

	private String cpfCnpj;
	private String name;
	private String signUpState;
	private String email;

	public CustomerBuilder withCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
		return this;
	}

	public CustomerBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CustomerBuilder withSignUpState(String signUpState) {
		this.signUpState = signUpState;
		return this;
	}
	
	public CustomerBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public Customer build() {
		Customer customer = new Customer();
		customer.setCpfCnpj(cpfCnpj);
		customer.setName(name);
		customer.setSignUpState(signUpState);
		customer.setEmail(email);
		return customer ;
	}

}
