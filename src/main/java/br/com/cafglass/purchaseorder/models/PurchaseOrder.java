package br.com.cafglass.purchaseorder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseOrder {
	
	/*
	 * Numero do Pedido
	 */
	@Id @GeneratedValue
	public Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(nullable = false, updatable=false)
	public Date emissionDate;
	 
	@ManyToOne
	public Address customerAddressSender;
	
	public String phoneSender;
	
	@ManyToOne
	public Address customerAddressRecipient;
	
	public String phoneRecipient;
	//public String faxRecipient;
	public String contactRecipient;
	public String condicaoPagamento; // --->>>> ????
	
//	@ManyToOne
//	public Customer shippingCompany;

	@ManyToOne
	public Address customerAddressShippingCompany;
	
	public String phoneShippingCompany;
	public char typeFreight; // ???? FOB
	public String remark;

	@JsonIgnore
	@OneToMany(mappedBy="purchaseOrder")
	public List<OrdersProducts> ordersProducts;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition= "varchar(20) default 'pending'")
	private StatusType status = StatusType.pending;
	
	@ManyToOne //@Column(nullable=false)
	private User userCreated;
	
	private String representative;
	
	public PurchaseOrder() {}
	
	public PurchaseOrder(Long id) {
		this.id = id;
	}
	
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
	public String getContactRecipient() {
		return contactRecipient;
	}
	public void setContactRecipient(String contactRecipient) {
		this.contactRecipient = contactRecipient;
	}
	public Address getCustomerAddressShippingCompany() {
		return customerAddressShippingCompany;
	}
	public void setCustomerAddressShippingCompany(Address customerAddressShippingCompany) {
		this.customerAddressShippingCompany = customerAddressShippingCompany;
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
	
	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}	
	
	public User getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(User userCreated) {
		this.userCreated = userCreated;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", emissionDate=" + emissionDate
				+ ", customerAddressSender=" + customerAddressSender
				+ ", phoneSender=" + phoneSender
				+ ", customerAddressRecipient=" + customerAddressRecipient
				+ ", phoneRecipient=" + phoneRecipient + ", contactRecipient="
				+ contactRecipient + ", condicaoPagamento=" + condicaoPagamento
				+ ", customerAddressShippingCompany=" + customerAddressShippingCompany
				+ ", phoneShippingCompany=" + phoneShippingCompany
				+ ", typeFreight=" + typeFreight + ", remark=" + remark
				+ ", status=" + status + ", userCreated=" + userCreated + "]";
	}

	

}
