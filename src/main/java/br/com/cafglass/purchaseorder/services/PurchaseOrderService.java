package br.com.cafglass.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cafglass.purchaseorder.models.PurchaseOrder;
import br.com.cafglass.purchaseorder.repositories.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	public List<PurchaseOrder> findAll() { 
		return (List<PurchaseOrder>) this.purchaseOrderRepository.findAll();
	}

}
