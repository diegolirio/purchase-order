package com.diegolirio.purchaseorder.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.ProductType;
import com.diegolirio.purchaseorder.services.ProductTypeService;

@Controller
@RequestMapping("/producttype")
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * pega todos
	 * @return
	 */
	@RequestMapping(value="/get/all", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getAll() {
		try {
			Iterable<ProductType> types = this.productTypeService.getAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(types), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
