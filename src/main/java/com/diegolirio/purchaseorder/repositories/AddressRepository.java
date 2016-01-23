package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
