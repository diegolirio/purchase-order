package com.diegolirio.purchaseorder.builder;

import java.util.Date;

import com.diegolirio.purchaseorder.models.PurchaseOrder;

public class PurchaseOrderBuilder {

	private Date emissionDate;

	public PurchaseOrderBuilder withEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
		return this;
	}

	public PurchaseOrder build() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setEmissionDate(emissionDate);
		return purchaseOrder;
	}

}
