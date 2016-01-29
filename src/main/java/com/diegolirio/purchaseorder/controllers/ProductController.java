package com.diegolirio.purchaseorder.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.Product;
import com.diegolirio.purchaseorder.services.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/*
	 * pages
	 */
	
	@RequestMapping(value="/page/list")
	public String pageList() {
		return "product/list";
	}
	
	/*
	 * restFull
	 */
	
	/**
	 * pega todos clientes
	 * @param cpfCnpj
	 * @return
	 */
	@RequestMapping(value="/get/all", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getall() {
		try {
			Iterable<Product> all = this.productService.getAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(all ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
