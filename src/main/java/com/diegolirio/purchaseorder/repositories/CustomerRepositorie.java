package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Customer;

@Repository
public interface CustomerRepositorie extends CrudRepository<Customer, Long> {

}
