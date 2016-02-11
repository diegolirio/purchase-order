package com.diegolirio.purchaseorder.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.StatusType;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepositorie;

@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepositorie purchaseOrderRepositorie;
	@Autowired
	private com.diegolirio.purchaseorder.services.mail.Mail mail;
	
	public Iterable<PurchaseOrder> getAll() {
		return this.purchaseOrderRepositorie.findAll();
	}
	
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		if(purchaseOrder.getId() <= 0) purchaseOrder.setEmissionDate(Calendar.getInstance().getTime());
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
			//throw new RuntimeException("Email não enviado para o Cliente");
		}
		return po;
	}
	
	/**
	 * Send Mail for Customer
	 * @param 
	 * @return
	 */
	public boolean sendEmail(PurchaseOrder po) {
		return this.mail.sendMail(po.getCustomerAddressRecipient().getPeople().getEmail(), po.getCustomerAddressSender().getPeople().getEmail());
	}

	public PurchaseOrder searchAdvanced(String status, String dateStart, String dateEnd) {
		return this.purchaseOrderRepositorie.findByStatusAndEmissionDateBetween(status, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}
	
}
