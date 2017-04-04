package br.com.cafglass.purchaseorder.apis;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cafglass.purchaseorder.models.PurchaseOrder;
import br.com.cafglass.purchaseorder.services.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchaseorder")
public class PurchaseOrderRestController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@RequestMapping(value="/findall", produces="application/json", method=RequestMethod.GET)
	public ResponseEntity<String> findAll(HttpServletResponse response) {
		try {
			List<PurchaseOrder> list = this.purchaseOrderService.findAll();
			return CommonController.toJson(list);
		}catch(Exception e) {
			e.printStackTrace();
			return CommonController.responseEntityError(e);
		}
	}
}
