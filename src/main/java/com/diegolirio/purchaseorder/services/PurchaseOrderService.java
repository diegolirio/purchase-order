package com.diegolirio.purchaseorder.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		if(purchaseOrder.getId() == null || purchaseOrder.getId() <= 0) purchaseOrder.setEmissionDate(Calendar.getInstance().getTime());
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

	public List<PurchaseOrder> searchAdvanced(StatusType status, String dateStart, String dateEnd) {
		//Calendar instance = Calendar.getInstance();
		//instance.add(Calendar.DATE, -30);
		 Date start = null;
		 Date end = null;
        try {
            //DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            start = (java.util.Date)formatter.parse(dateStart);
            end = (java.util.Date)formatter.parse(dateEnd);
        } catch (ParseException e) {            
            throw new RuntimeException(e);
        }
		return this.purchaseOrderRepositorie.findByStatusAndEmissionDateBetween(status, start, end);
	}
	
}
