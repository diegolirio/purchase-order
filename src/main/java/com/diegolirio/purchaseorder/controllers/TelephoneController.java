package com.diegolirio.purchaseorder.controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.Telephone;
import com.diegolirio.purchaseorder.services.TelephoneService;

@Controller
@RequestMapping("/telephone")
public class TelephoneController {

	@Autowired
	private TelephoneService telephoneService;

	/**
	 * pega a lista de telephone da Pessoa
	 * @param peopleId
	 * @return
	 */
	@RequestMapping(value="/get/list/by/people/{peopleId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByPeople(@PathVariable("peopleId") Long peopleId) {
		try {
			List<Telephone> phones = this.telephoneService.getListByPeople(new Customer(peopleId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(phones), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Salvar
	 * @param telephone
	 * @return
	 */
	@RequestMapping(value="/saveParams", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> saveParams(Telephone telephone) {
		try {
			telephone = this.telephoneService.save(telephone);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(telephone), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * delete or desactive
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			this.telephoneService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
}
