package com.diegolirio.purchaseorder.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class EmailCcPO {

	@Id @GeneratedValue
	private Long id;
	
	private String emailCc;
	
	//private EmailSettingsPO emailSettingsPO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailCc() {
		return emailCc;
	}

	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}
	
	
	
}
