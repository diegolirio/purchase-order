package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Customer;

@Repository
public interface CustomerRepositorie extends CrudRepository<Customer, Long> {

	public List<Customer> findByNameContainingAndActive(String name, boolean active);

	public Iterable<Customer> findByActive(boolean active);
	
	@Query("select c from Customer c where (c.cpfCnpj like %?1% or c.name like %?2% or c.email like %?3% or c.signUpState like %?4%) and c.active = ?5")
	public List<Customer> findAdvanced(String cpfCnpj, String name, String email, String signUpState, boolean active);

	public Customer findByCpfCnpjAndActive(String cpfcnpj, boolean active);

	@Query("select c from Customer c where (c.cpfCnpj like %?1% or c.name like %?2%) and c.active = ?3")
	public List<Customer> findByCpfCnpjOrName(String cpfCnpj, String name, boolean active);

}
