package br.com.cafglass.purchaseorder.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonController {

	public static ResponseEntity<String> responseEntityError(Exception e) {
		return new ResponseEntity<String>("{\"messageError\": \""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<String> toJson(Object object) throws JsonProcessingException {
		return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(object), HttpStatus.OK);
	}
	
}
