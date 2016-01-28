package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.People;
import com.diegolirio.purchaseorder.models.Telephone;
import com.diegolirio.purchaseorder.repositories.TelephoneRepositorie;

@Service
public class TelephoneService {

	@Autowired
	private TelephoneRepositorie telephoneRepositorie;

	public List<Telephone> getListByPeople(People people) {
		return this.telephoneRepositorie.findByPeople(people);
	}

	
	
}
