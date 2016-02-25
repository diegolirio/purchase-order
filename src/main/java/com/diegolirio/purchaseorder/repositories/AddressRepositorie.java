package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.People;

@Repository
public interface AddressRepositorie extends CrudRepository<Address, Long> {

	public List<Address> findByPeopleAndActive(People people, boolean active);

}
