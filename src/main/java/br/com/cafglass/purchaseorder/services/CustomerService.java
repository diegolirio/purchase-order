package br.com.cafglass.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cafglass.purchaseorder.models.Customer;
import br.com.cafglass.purchaseorder.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return (List<Customer>) this.customerRepository.findAll();
	}

	public Customer save(Customer customer) {
		return this.customerRepository.save(customer);
	}

	public Customer findOne(Long id) {
		return this.customerRepository.findOne(id);
	}

	public void delete(Long id) {
		this.customerRepository.delete(id);
	}
	
}
