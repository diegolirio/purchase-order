package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.StatusType;
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

	/**
	 * Efetiva -> Muda status, Envia email
	 * @param id
	 * @return
	 */
	public PurchaseOrder completed(long id) {
		PurchaseOrder po = this.purchaseOrderRepositorie.findOne(id);
		po.setStatus(StatusType.completed);
		this.purchaseOrderRepositorie.save(po);
		boolean sent = this.sendEmail(po);
		if(sent == false) {
			throw new RuntimeException("Email não enviado para o Cliente");
		}
		return po;
	}
	
	/**
	 * Send Mail for Customer
	 * @param po
	 * @return
	 */
	public boolean sendEmail(PurchaseOrder po) {
		return true;
	}
	
}
