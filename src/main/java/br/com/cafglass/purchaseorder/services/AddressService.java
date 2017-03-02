package br.com.cafglass.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cafglass.purchaseorder.models.Address;
import br.com.cafglass.purchaseorder.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findByPeopleId(Long peopleId) {
		return this.addressRepository.findByPeopleId(peopleId);
	}

	public Address save(Address address) {
		return this.addressRepository.save(address);
	}

}
