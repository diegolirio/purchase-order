package com.diegolirio.purchaseorder.reports.mirror;

import java.util.Date;

public class PO {
	
	private long number;
	private Date emissionDate;
	// sender
	private String cnpjSender;
	private String ieSender;
	private String nameSender;
	private String phoneSender;
	private String addressSender;
	private String neighborhoodSender;
	private String citySender;
	private String stateSender;
	private String cepSender;
	
	// recipient
	private String nameRecipient;
	private String cnpjRecipient;
	private String addressRecipient;
	private String neighborhoodRecipient;
	private String cepRecipient;
	private String cityRecipient;
	private String stateRecipient;
	private String ieRecipient;
	private String phone1Recipient;
	private String contactRecipient;
	// transport
	private String nameShippingCompany;
	private String phoneShippingCompany;
	// ??
	private String representative;
	private String paymentConditions;
	private String remark;
	private int addressNumberSender;
	private int addressNumberRecipient;
	private String addressShippingCompany;
	private int addressNumberShippingCompany;
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public Date getEmissionDate() {
		return emissionDate;
	}
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}
	public String getCnpjSender() {
		return cnpjSender;
	}
	public void setCnpjSender(String cnpjSender) {
		this.cnpjSender = cnpjSender;
	}
	public String getIeSender() {
		return ieSender;
	}
	public void setIeSender(String ieSender) {
		this.ieSender = ieSender;
	}
	public String getNameSender() {
		return nameSender;
	}
	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}
	public String getAddressSender() {
		return addressSender;
	}
	public void setAddressSender(String addressSender) {
		this.addressSender = addressSender;
	}
	public int getAddressNumberSender() {
		return addressNumberSender;
	}
	public void setAddressNumberSender(int addressNumberSender) {
		this.addressNumberSender = addressNumberSender;
	}
	public String getPhoneSender() {
		return phoneSender;
	}
	public void setPhoneSender(String phoneSender) {
		this.phoneSender = phoneSender;
	}
	public String getCitySender() {
		return citySender;
	}
	public void setCitySender(String citySender) {
		this.citySender = citySender;
		
	}	
	public String getNeighborhoodSender() {
		return neighborhoodSender;
	}
	public void setNeighborhoodSender(String neighborhoodSender) {
		this.neighborhoodSender = neighborhoodSender;	
	}	
	public String getStateSender() {
		return stateSender;
	}
	public void setStateSender(String stateSender) {
		this.stateSender = stateSender;
	}

	public String getCepSender() {
		return cepSender;
	}
	public void setCepSender(String cepSender) {
		this.cepSender = cepSender;
	}
	public String getNameRecipient() {
		return nameRecipient;
	}
	public void setNameRecipient(String nameRecipient) {
		this.nameRecipient = nameRecipient;
	}
	public String getCnpjRecipient() {
		return cnpjRecipient;
	}
	public void setCnpjRecipient(String cnpjRecipient) {
		this.cnpjRecipient = cnpjRecipient;
	}
	public String getAddressRecipient() {
		return addressRecipient;
	}
	public void setAddressRecipient(String addressRecipient) {
		this.addressRecipient = addressRecipient;
	}
	public int getAddressNumberRecipient() {
		return addressNumberRecipient;
	}
	public void setAddressNumberRecipient(int addressNumberRecipient) {
		this.addressNumberRecipient = addressNumberRecipient;
	}
	public String getNeighborhoodRecipient() {
		return neighborhoodRecipient;
	}
	public void setNeighborhoodRecipient(String neighborhoodRecipient) {
		this.neighborhoodRecipient = neighborhoodRecipient;
	}
	public String getCepRecipient() {
		return cepRecipient;
	}
	public void setCepRecipient(String cepRecipient) {
		this.cepRecipient = cepRecipient;
	}
	public String getCityRecipient() {
		return cityRecipient;
	}
	public void setCityRecipient(String cityRecipient) {
		this.cityRecipient = cityRecipient;
	}
	public String getStateRecipient() {
		return stateRecipient;
	}
	public void setStateRecipient(String stateRecipient) {
		this.stateRecipient = stateRecipient;
	}
	public String getIeRecipient() {
		return ieRecipient;
	}
	public void setIeRecipient(String ieRecipient) {
		this.ieRecipient = ieRecipient;
	}
	public String getPhone1Recipient() {
		return phone1Recipient;
	}
	public void setPhone1Recipient(String phone1Recipient) {
		this.phone1Recipient = phone1Recipient;
	}
	public String getContactRecipient() {
		return contactRecipient;
	}
	public void setContactRecipient(String contactRecipient) {
		this.contactRecipient = contactRecipient;
	}
	public String getNameShippingCompany() {
		return nameShippingCompany;
	}
	public void setNameShippingCompany(String nameShippingCompany) {
		this.nameShippingCompany = nameShippingCompany;
	}
	public String getPhoneShippingCompany() {
		return phoneShippingCompany;
	}
	public void setPhoneShippingCompany(String phoneShippingCompany) {
		this.phoneShippingCompany = phoneShippingCompany;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public String getPaymentConditions() {
		return paymentConditions;
	}
	public void setPaymentConditions(String paymentConditions) {
		this.paymentConditions = paymentConditions;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddressShippingCompany() {
		return addressShippingCompany;
	}
	public void setAddressShippingCompany(String addressShippingCompany) {
		this.addressShippingCompany = addressShippingCompany;
	}
	
	public int getAddressNumberShippingCompany() {
		return addressNumberShippingCompany;
	}
	public void setAddressNumberShippingCompany(int addressNumberShippingCompany) {
		this.addressNumberShippingCompany = addressNumberShippingCompany;
	}
	@Override
	public String toString() {
		return "PO [number=" + number + ", emissionDate=" + emissionDate
				+ ", cnpjSender=" + cnpjSender + ", ieSender=" + ieSender
				+ ", nameSender=" + nameSender + ", addressSender="
				+ addressSender + ", phoneSender=" + phoneSender
				+ ", nameRecipient=" + nameRecipient + ", cnpjRecipient="
				+ cnpjRecipient + ", addressRecipient=" + addressRecipient
				+ ", neighborhoodRecipient=" + neighborhoodRecipient
				+ ", cepRecipient=" + cepRecipient + ", cityRecipient="
				+ cityRecipient + ", stateRecipient=" + stateRecipient
				+ ", ieRecipient=" + ieRecipient + ", phone1Recipient="
				+ phone1Recipient + ", contactRecipient=" + contactRecipient
				+ ", nameShippingCompany=" + nameShippingCompany
				+ ", phoneShippingCompany=" + phoneShippingCompany
				+ ", representative=" + representative + ", paymentConditions="
				+ paymentConditions + ", remark=" + remark + "]";
	}
	


}
