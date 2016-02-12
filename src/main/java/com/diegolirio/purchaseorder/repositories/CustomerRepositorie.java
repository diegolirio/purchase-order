package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Customer;

@Repository
public interface CustomerRepositorie extends CrudRepository<Customer, Long> {

	public List<Customer> findByCpfCnpj(String cpfcnpj);

	public List<Customer> findByCpfCnpjContainingOrNameContainingIgnoreCase(String cpfCnpj, String name);

	public List<Customer> findByNameContainingIgnoreCase(String name);

}
