package com.diegolirio.purchaseorder.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.State;
import com.diegolirio.purchaseorder.services.StateService;

@Controller
@RequestMapping(value="/state")
public class StateController {

	@Autowired
	private StateService stateService;

	/**
	 * Pega Todos
	 * @return
	 */
	@RequestMapping(value="/get/all", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getAll() {
		try {
			Iterable<State> states = this.stateService.getAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(states), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
