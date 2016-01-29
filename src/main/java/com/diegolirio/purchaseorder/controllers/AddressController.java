package com.diegolirio.purchaseorder.controllers;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.services.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(value="/get/list/by/people/{peopleId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByPeople(@PathVariable("peopleId") Long peopleId) {
		try {
			List<Address> address = this.addressService.getListByPeople(new Customer(peopleId)); 
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(address ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Address address) {
		try {
			address = this.addressService.save(address);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(address), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/saveParams", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> saveParams(Address address) {
		try {
			address = this.addressService.save(address);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(address), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
