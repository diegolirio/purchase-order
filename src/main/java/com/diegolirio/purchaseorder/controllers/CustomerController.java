package com.diegolirio.purchaseorder.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*
	 * pages
	 */
	
	@RequestMapping(value="/page/list")
	public String pageList() {
		return "customer/list";
	}
	
	@RequestMapping(value="/page/form")
	public String pageForm() {
		return "customer/form";
	}
	
	/*
	 * RestFull
	 */
	
	/**
	 * pega Cliente pelo id
	 * @param id
	 * @return Customer (JSON)
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Customer customer = this.customerService.get(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(customer ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega cliente por cpfCnpj
	 * @param cpfCnpj
	 * @return
	 */
	@RequestMapping(value="/get/by/cpfcnpj/{cpfCnpj}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj) {
		try {
			Customer customer = this.customerService.getByCpfCnpj(cpfCnpj);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(customer ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega todos clientes
	 * @param cpfCnpj
	 * @return
	 */
	@RequestMapping(value="/get/all", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getall() {
		try {
			Iterable<Customer> all = this.customerService.getAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(all ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar Cliente
	 * @param customer (JSON)
	 * @return customer (JSON)
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(Customer customer) { 
		try {
			System.out.println(customer);
			customer = this.customerService.save(customer);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(customer), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
