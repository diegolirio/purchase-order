package br.com.cafglass.purchaseorder.apis;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cafglass.purchaseorder.models.Customer;
import br.com.cafglass.purchaseorder.services.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/findall", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<String> findAll(HttpServletResponse response) {
		try {
			List<Customer> list = this.customerService.findAll();
			return CommonController.toJson(list);
		}catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> save(@RequestBody Customer customer, HttpServletResponse response) {
		System.out.println(customer); 
		try {
			customer = this.customerService.save(customer);
			return CommonController.toJson(customer);
		} catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}
	
	@RequestMapping(value="/findone/{id}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<String> findOne(@PathVariable("id") Long id, HttpServletResponse response) {
		System.out.println("findAll()");
		try {
			Customer customer = this.customerService.findOne(id);
			return CommonController.toJson(customer);
		}catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> save(@PathVariable("id") Long id, HttpServletResponse response) {	 
		try {
			this.customerService.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}
}
