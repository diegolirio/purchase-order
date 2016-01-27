package com.diegolirio.purchaseorder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class PurchaseOrder {
	
	/*
	 * Numero do Pedido
	 */
	@Id @GeneratedValue
	public Long id;
	
	@Temporal(javax.persistence.TemporalType.DATE) 
	public Date emissionDate;
	
	@ManyToOne
	public Address customerAddressSender;
	
	
	public String phoneSender;
	
	@ManyToOne
	public Address customerAddressRecipient;
	
	public String phoneRecipient;
	public String faxRecipient;
	public String condicaoPagamento; // --->>>> ????
	
	@ManyToOne
	public Customer shippingCompany;
	public String phoneShippingCompany;
	public char typeFreight; // ???? FOB
	public String remark;

	@JsonIgnore
	@OneToMany(mappedBy="purchaseOrder")
	public List<OrdersProducts> ordersProducts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEmissionDate() {
		return emissionDate;
	}
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}
	public Address getCustomerAddressSender() {
		return customerAddressSender;
	}
	public void setCustomerAddressSender(Address customerAddressSender) {
		this.customerAddressSender = customerAddressSender;
	}
	public String getPhoneSender() {
		return phoneSender;
	}
	public void setPhoneSender(String phoneSender) {
		this.phoneSender = phoneSender;
	}
	public Address getCustomerAddressRecipient() {
		return customerAddressRecipient;
	}
	public void setCustomerAddressRecipient(Address customerAddressRecipient) {
		this.customerAddressRecipient = customerAddressRecipient;
	}
	public String getPhoneRecipient() {
		return phoneRecipient;
	}
	public void setPhoneRecipient(String phoneRecipient) {
		this.phoneRecipient = phoneRecipient;
	}
	public String getFaxRecipient() {
		return faxRecipient;
	}
	public void setFaxRecipient(String faxRecipient) {
		this.faxRecipient = faxRecipient;
	}
	public Customer getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(Customer shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	public String getPhoneShippingCompany() {
		return phoneShippingCompany;
	}
	public void setPhoneShippingCompany(String phoneShippingCompany) {
		this.phoneShippingCompany = phoneShippingCompany;
	}
	public char getTypeFreight() {
		return typeFreight;
	}
	public void setTypeFreight(char typeFreight) {
		this.typeFreight = typeFreight;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getCondicaoPagamento() {
		return condicaoPagamento;
	}
	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
	public List<OrdersProducts> getOrdersProducts() {
		return ordersProducts;
	}
	public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
		this.ordersProducts = ordersProducts;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", emissionDate=" + emissionDate
				+ ", customerAddressSender=" + customerAddressSender
				+ ", phoneSender=" + phoneSender + ", customerAddressRecipient="
				+ customerAddressRecipient + ", phoneRecipient=" + phoneRecipient
				+ ", faxRecipient=" + faxRecipient + ", shippingCompany="
				+ shippingCompany + ", phoneShippingCompany="
				+ phoneShippingCompany + ", typeFreight=" + typeFreight
				+ ", remark=" + remark + "]";
	}
	
	

}
