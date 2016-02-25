package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Telephone save(Telephone telephone) {
		if(telephone.getId() > 0) {
			Telephone t = Telephone.getNewInstance(telephone);
			this.delete(telephone);
			return this.telephoneRepositorie.save(t);
		}
		else return this.telephoneRepositorie.save(telephone);		
	}

	/**
	 * Delete telephone if using desactive
	 * @param id
	 */
	public void delete(long id) {
		try {
			telephoneRepositorie.delete(id);
		} catch(ConstraintViolationException|DataIntegrityViolationException cve) {
			Telephone addDesac = this.telephoneRepositorie.findOne(id);
			addDesac.setActive(false);
			telephoneRepositorie.save(addDesac);
		}	
	}
	
	/**
	 * Delete telephone if using desactive
	 * @param telephone
	 */
	public void delete(Telephone telephone) {
		this.delete(telephone.getId());
	}

	
	
}
