package br.com.cafglass.purchaseorder.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonController {

	public static ResponseEntity<String> responseEntityError(Exception e) {
		return new ResponseEntity<String>("{\"messageError\": \""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
