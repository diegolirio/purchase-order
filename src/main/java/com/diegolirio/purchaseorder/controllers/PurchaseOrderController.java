package com.diegolirio.purchaseorder.controllers;

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
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.services.AddressService;
import com.diegolirio.purchaseorder.services.PurchaseOrderService;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	@Autowired
	private AddressService addressService;

	/*
	 * Page
	 */
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/page/list")
	public String pageList() {
		return "purchaseorder/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/page/form")
	public String pageForm() {
		return "purchaseorder/form";
	}
	
	/*
	 * RestFull
	 */

	/**
	 * pega todos os pedidos
	 * @return JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") Long id) {
		try {
			PurchaseOrder purchaseOrder = this.purchaseOrderService.get(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrder), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * pega todos os pedidos
	 * @return JSON
	 */
	@RequestMapping(value="/get/all", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getAll() {
		try {
			Iterable<PurchaseOrder> purchaseOrders = this.purchaseOrderService.getAll();
			//List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrders), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar P.O.
	 * @param purchaseOrder
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody PurchaseOrder purchaseOrder) {
		try {
			System.out.println(purchaseOrder);
			Address customerAddressRecipient = this.addressService.get(purchaseOrder.getCustomerAddressRecipient().getId());
			purchaseOrder.setCustomerAddressRecipient(customerAddressRecipient);
			purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrder), HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Salvar P.O. Params
	 * @param purchaseOrder
	 * @return
	 */
	@RequestMapping(value="/saveParams", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> saveParams(PurchaseOrder purchaseOrder) {
		try {
			purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrder), HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
