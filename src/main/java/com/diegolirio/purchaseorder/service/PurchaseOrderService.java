package com.diegolirio.purchaseorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		return this.purchaseOrderRepository.save(purchaseOrder);
	}
	
}
