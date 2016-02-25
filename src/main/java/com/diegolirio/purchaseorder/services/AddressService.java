package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.People;
import com.diegolirio.purchaseorder.repositories.AddressRepositorie;

@Service
public class AddressService {

	@Autowired
	private AddressRepositorie addressRepositorie;

	public List<Address> getListByPeople(People people) {
		return this.addressRepositorie.findByPeopleAndActive(people, true);
	}

	public Address save(Address address) {
		if(address.getId() > 0) {
			Address a = Address.getNewInstance(address);
			this.delete(address);
			return this.addressRepositorie.save(a);
		}
		else return this.addressRepositorie.save(address);
	}

	/**
	 * Delete address if using desactive
	 * @param id
	 */
	public void delete(long id) {
		try {
			addressRepositorie.delete(id);
		} catch(ConstraintViolationException|DataIntegrityViolationException cve) {
			Address addDesac = this.addressRepositorie.findOne(id);
			addDesac.setActive(false);
			addressRepositorie.save(addDesac);
		}	
	}
	
	/**
	 * Delete address if using desactive
	 * @param address
	 */
	public void delete(Address address) {
		this.delete(address.getId());
	}

	public Address get(Long id) {
		return this.addressRepositorie.findOne(id);
	}

}
