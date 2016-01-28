package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.repositories.CustomerRepositorie;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepositorie customerRepositorie;

	public Customer getByCpfCnpj(String cpfcnpj) {
		List<Customer> customers = this.customerRepositorie.findByCpfCnpj(cpfcnpj);
		return customers == null || customers.size() == 0 ? null : customers.get(0);
	}

	public Customer save(Customer customer) {
		return this.customerRepositorie.save(customer);
	}

	
	
}
