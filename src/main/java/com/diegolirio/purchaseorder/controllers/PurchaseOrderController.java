package com.diegolirio.purchaseorder.controllers;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.services.PurchaseOrderService;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {

//	@Autowired
//	private PurchaseOrderService purchaseOrderService;

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
	
	/*
	 * RestFull
	 */
	
	/**
	 * pega todos os pedidos
	 * @return JSON
	 */
	@RequestMapping(value="/get/all", method=RequestMethod.GET, consumes="application/json; charset=UTF-8")
	public ResponseEntity<String> getAll() {
		try {
			//Iterable<PurchaseOrder> purchaseOrders = this.purchaseOrderService.getAll();
			List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrders), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
