package br.com.cafglass.purchaseorder.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cafglass.purchaseorder.models.Address;
import br.com.cafglass.purchaseorder.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressRestController {
	
	@Autowired
	private AddressService addressService;

	@RequestMapping(value="/findbypeople/{peopleId}", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<String> findByPeople(@PathVariable("peopleId") Long peopleId) {
		try {
			List<Address> list = this.addressService.findByPeopleId(peopleId);
			return CommonController.toJson(list);
		}catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}

	@RequestMapping(value="/save", consumes="application/json", produces="application/json", method=RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Address address) {
		try {
			address = this.addressService.save(address);
			return CommonController.toJson(address);
		}catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}
	
	
	
}
