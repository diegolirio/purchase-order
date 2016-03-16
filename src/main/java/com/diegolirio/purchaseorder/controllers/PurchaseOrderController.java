package com.diegolirio.purchaseorder.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.StatusType;
import com.diegolirio.purchaseorder.services.AddressService;
import com.diegolirio.purchaseorder.services.OrdersProductsService;
import com.diegolirio.purchaseorder.services.PurchaseOrderService;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrdersProductsService ordersProductsService;

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
	
	/**
	 * Gera Relatorio passando devolvendo em um array de byte
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws JRException
	 */
	@RequestMapping(value="/{id}/print/pdf")
	public void print(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
		byte bytes [] = this.purchaseOrderService.generateReport(id);
		response.setContentType("application/pdf");
		response.getOutputStream().write(bytes); 
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/page/edit")
	public String pageView() {
		return "purchaseorder/edit";
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
			System.out.println(purchaseOrder);
			purchaseOrder.setStatus(StatusType.pending);
			purchaseOrder = this.purchaseOrderService.save(purchaseOrder);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrder), HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Completed P.O.
	 * @param purchaseOrder
	 * @return
	 */
	@RequestMapping(value="/completed/{id}", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> completed(@PathVariable("id") long id) {
		try {
			PurchaseOrder purchaseOrder = this.purchaseOrderService.completed(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(purchaseOrder), HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * Search Advanced
	 * @param status
	 * @return list
	 */
	@RequestMapping(value="/search/advanced/{status}/{dateStart}/{dateEnd}", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> searchAdvanced(@PathVariable("status") StatusType status, @PathVariable("dateStart") String dateStart, @PathVariable("dateEnd") String dateEnd) {
		try {
			System.out.println(dateStart + " a " + dateEnd);
			List<PurchaseOrder> list = this.purchaseOrderService.searchAdvanced(status, dateStart, dateEnd);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	/**
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	@RequestMapping(value="/find/by/emissiondate/{dateStart}/{dateEnd}", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> findByEmissionDateBetween(@PathVariable("dateStart") String dateStart, @PathVariable("dateEnd") String dateEnd) {
		try {
			List<PurchaseOrder> list = this.purchaseOrderService.findByEmissionDateBetween(dateStart, dateEnd);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	

	/**
	 * Delete P.O.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			this.purchaseOrderService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * Cancel P.O.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/cancel/{id}", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> cancel(@PathVariable("id") long id, String reason) {
		try {
			this.purchaseOrderService.cancel(id, reason);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/send/mail/{id}", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> sendMail(@PathVariable("id") long id) {
		try {
			this.purchaseOrderService.sendEmailAttachmentPO(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
