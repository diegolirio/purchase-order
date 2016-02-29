package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Customer;

@Repository
public interface CustomerRepositorie extends CrudRepository<Customer, Long> {

	public List<Customer> findByNameContaining(String name);

	public Iterable<Customer> findByActive(boolean active);

	//
	public List<Customer> findByCpfCnpjContainingOrNameContainingOrEmailContainingOrSignUpStateContaining(
					String cpfCnpj, String name, String email, String signUpState);
	
	@Query("select c from Customer c where c.active = true and (c.cpfCnpj like %?1% or c.name like %?2% or c.email like %?3% or c.signUpState like %?4%)")
	public List<Customer> findAdvanced(String cpfCnpj, String name, String email, String signUpState);

	public Customer findByCpfCnpjAndActive(String cpfcnpj, boolean active);

	@Query("select c from Customer c where c.active = true and (c.cpfCnpj like %?1% or c.name like %?2%)")
	public List<Customer> findByCpfCnpjOrName(String cpfCnpj, String name);

}
