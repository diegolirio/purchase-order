package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.EmailSettingsPO;

public class EmailSettingsPOBuilder {

	private Long id;
	private String from;
	private String host;
	private String password;
	private String port;
	private String username;

	public EmailSettingsPOBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public EmailSettingsPOBuilder withFromEmail(String from) {
		this.from = from;
		return this;
	}
	
	public EmailSettingsPOBuilder withHost(String host) {
		this.host = host;
		return this;
	}
	
	public EmailSettingsPOBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public EmailSettingsPOBuilder withPort(String port) {
		this.port = port;
		return this;
	}
	
	public EmailSettingsPOBuilder withUsername(String username) {
		this.username = username;
		return this;
	}
	
	public EmailSettingsPO build() {
		EmailSettingsPO emailSettingsPO = new EmailSettingsPO();
		emailSettingsPO.setId(id);
		emailSettingsPO.setFromEmail(from);
		emailSettingsPO.setHost(host);
		emailSettingsPO.setPassword(password);
		emailSettingsPO.setPort(port);
		emailSettingsPO.setUsername(username);
		return emailSettingsPO;
	}
	
}
