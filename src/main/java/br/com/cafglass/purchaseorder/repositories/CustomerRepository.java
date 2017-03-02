package br.com.cafglass.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cafglass.purchaseorder.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
