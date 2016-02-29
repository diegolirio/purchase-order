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
	
	@RequestMapping(value="/page/form")
	public String pageFOrm() {
		return "product/form";
	}
	
	/*
	 * restFull
	 */
	
	/**
	 * pega por id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Product p = this.productService.get(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(p), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	/**
	 * 
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
	
	/**
	 * pega por codigo
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/get/by/code/{code}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByCode(@PathVariable("code") String code) {
		try {
			Product product = this.productService.getByCode(code);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(product), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pesquisa produto por codigo or descricao
	 * @param code
	 * @param description
	 * @return
	 */
	@RequestMapping(value="/get/by/code/{code}/or/description/{description}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByCodeOrDescription(@PathVariable("code") String code, @PathVariable("description") String description) {
		try {
			List<Product> products = this.productService.getByCodeOrDescription(code, description);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(products), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * find advanced
	 * @param fieldSearch
	 * @return list of product
	 */
	@RequestMapping(value="/find/advanced/{fieldSearch}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findAdvanced(@PathVariable("fieldSearch") String fieldSearch) {
		try {
			List<Product> list = this.productService.findAdvanced(fieldSearch); 
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Product product) {
		try {
			product = this.productService.save(product);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(product), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/saveParams", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> saveParams(Product product) {
		try {
			product = this.productService.save(product);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(product), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * delete/desactive
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			this.productService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
