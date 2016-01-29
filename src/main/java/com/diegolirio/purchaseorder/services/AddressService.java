package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.People;
import com.diegolirio.purchaseorder.repositories.AddressRepositorie;

@Service
public class AddressService {

	@Autowired
	private AddressRepositorie addressRepositorie;

	public List<Address> getListByPeople(People people) {
		return this.addressRepositorie.findByPeople(people);
	}

	public Address save(Address address) {
		return this.addressRepositorie.save(address);
	}

}
