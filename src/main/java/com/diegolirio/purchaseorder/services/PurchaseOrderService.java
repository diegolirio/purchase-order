package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepositorie;

@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepositorie purchaseOrderRepositorie;
	
	public Iterable<PurchaseOrder> getAll() {
		return this.purchaseOrderRepositorie.findAll();
	}
	
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		return this.purchaseOrderRepositorie.save(purchaseOrder);
	}

	public PurchaseOrder get(Long id) {
		return this.purchaseOrderRepositorie.findOne(id);
	}
	
}
