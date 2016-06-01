package com.diegolirio.purchaseorder.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.EmailSettingsPO;
import com.diegolirio.purchaseorder.services.EmailSettingsPOService;

@Controller
@RequestMapping("emailsettingspo")
public class EmailSettingsPOController {

	@Autowired
	private EmailSettingsPOService emailSettingsPOService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/get/main", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getMain() {
		try {
			EmailSettingsPO value = this.emailSettingsPOService.getMain();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(value), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json;charset=UTF-8", produces="application/json")
	public ResponseEntity<String> save(@RequestBody EmailSettingsPO emailSettingsPO) {
		try {
			EmailSettingsPO value = this.emailSettingsPOService.save(emailSettingsPO);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(value), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/saveParams", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> saveParams(EmailSettingsPO emailSettingsPO) {
		try {
			EmailSettingsPO value = this.emailSettingsPOService.save(emailSettingsPO);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(value), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
