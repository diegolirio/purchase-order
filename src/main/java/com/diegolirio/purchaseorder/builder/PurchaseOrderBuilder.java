package com.diegolirio.purchaseorder.builder;

import java.util.Date;
import java.util.List;

import com.diegolirio.purchaseorder.models.Address;
import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.PurchaseOrder;

public class PurchaseOrderBuilder {

	private Date emissionDate;
	private Address customerAddressRecipient;
	private Address customerAddressSender;
	private String contactRecipient;
	private Long id;
	private List<OrdersProducts> ordersProducts;
	private String phoneRecipient;
	private String phoneSender;
	private String phoneShippingCompany;
	private String remark;
	private Address customerAddressShippingCompany;
	private char typeFreight;
	private String condicaoPagamento;

	public PurchaseOrderBuilder withEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
		return this;
	}

	public PurchaseOrderBuilder withCustomerAddressRecipient(Address customerAddressRecipient) {
		this.customerAddressRecipient = customerAddressRecipient;
		return this;
	}

	public PurchaseOrderBuilder withCustomerAddressSender(Address customerAddressSender) {
		this.customerAddressSender = customerAddressSender;
		return this;
	}

	public PurchaseOrderBuilder withContactRecipient(String contactRecipient) {
		this.contactRecipient = contactRecipient;
		return this;
	}
	
	public PurchaseOrderBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public PurchaseOrderBuilder withOrdersProducts(List<OrdersProducts> ordersProducts) {
		this.ordersProducts = ordersProducts;
		return this;
	}
	
	public PurchaseOrderBuilder withPhoneSender(String phoneSender) {
		this.phoneSender = phoneSender;
		return this;
	}
	
	public PurchaseOrderBuilder withPhoneShippingCompany(String phoneShippingCompany) {
		this.phoneShippingCompany = phoneShippingCompany;
		return this;
	}
	
	public PurchaseOrderBuilder withCustomerAddressShippingCompany(Address customerAddressShippingCompany) {
		this.customerAddressShippingCompany = customerAddressShippingCompany;
		return this;
	}
	
	public PurchaseOrderBuilder withPhoneRecipient(String phoneRecipient) {
		this.phoneRecipient = phoneRecipient;
		return this;
	}
	
	public PurchaseOrderBuilder withRemark(String remark) {
		this.remark = remark;
		return this;
	}
	
	public PurchaseOrderBuilder withTypeFreight(char typeFreight) {
		this.typeFreight = typeFreight;
		return this;
	}
	

	public PurchaseOrderBuilder withCondicoesPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
		return this;
	}	

	public PurchaseOrder build() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setEmissionDate(emissionDate);
		purchaseOrder.setCustomerAddressRecipient(customerAddressRecipient);
		purchaseOrder.setCustomerAddressSender(customerAddressSender);
		purchaseOrder.setContactRecipient(contactRecipient);
		purchaseOrder.setId(id);
		purchaseOrder.setOrdersProducts(ordersProducts);
		purchaseOrder.setPhoneRecipient(phoneRecipient);
		purchaseOrder.setPhoneSender(phoneSender);
		purchaseOrder.setPhoneShippingCompany(phoneShippingCompany);
		purchaseOrder.setRemark(remark);
		purchaseOrder.setCustomerAddressShippingCompany(customerAddressShippingCompany);
		purchaseOrder.setTypeFreight(typeFreight);
		purchaseOrder.setCondicaoPagamento(condicaoPagamento);
		return purchaseOrder;
	}


}
