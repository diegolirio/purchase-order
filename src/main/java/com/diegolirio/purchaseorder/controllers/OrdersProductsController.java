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

import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.services.OrdersProductsService;

@Controller
@RequestMapping("orders_products")
public class OrdersProductsController {

	@Autowired
	private OrdersProductsService ordersProductsService;

	@RequestMapping(value="/get/list/by/po/{poId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> saveParams(@PathVariable("poId") long poId) {
		try {
			List<OrdersProducts> list = this.ordersProductsService.getListByPurchaseOrder(new PurchaseOrder(poId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar item (produto) na p.o
	 * @param orderProduct
	 * @return
	 */
	@RequestMapping(value="/saveParams", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> saveParams(OrdersProducts orderProduct) {
		try {
			System.out.println(orderProduct);
			orderProduct = this.ordersProductsService.save(orderProduct);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(orderProduct), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Delete item (produto) na p.o
	 * @param orderProduct
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			this.ordersProductsService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
