package com.diegolirio.purchaseorder.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/get/by/cpfcnpj/{cpfCnpj}")
	public ResponseEntity<String> getByCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj) {
		try {
			Customer customer = this.customerService.getByCpfCnpj(cpfCnpj);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(customer ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
