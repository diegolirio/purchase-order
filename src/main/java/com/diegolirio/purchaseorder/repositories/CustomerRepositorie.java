package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Customer;

@Repository
public interface CustomerRepositorie extends CrudRepository<Customer, Long> {

	public List<Customer> findByCpfCnpj(String cpfcnpj);

	//
	public List<Customer> findByNameContaining(String name);


	public Iterable<Customer> findByActive(boolean active);

	//
	public List<Customer> findByCpfCnpjContainingOrNameContaining(String cpfCnpj, String name);

	//
	public List<Customer> findByCpfCnpjContainingOrNameContainingOrEmailContainingOrSignUpStateContaining(
					String cpfCnpj, String name, String email, String signUpState);

}
