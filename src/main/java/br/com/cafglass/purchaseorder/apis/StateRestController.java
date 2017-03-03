package br.com.cafglass.purchaseorder.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cafglass.purchaseorder.models.State;
import br.com.cafglass.purchaseorder.services.StateService;

@RestController
@RequestMapping("/api/state")
public class StateRestController {

	@Autowired
	private StateService stateService;

	@RequestMapping(value="/findall", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> findAll() {
		try {
			List<State> list = this.stateService.findAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(list ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}

	@RequestMapping(value="/create", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> create() {
		try {
			this.stateService.create(); 
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}	
	
	
	
}
