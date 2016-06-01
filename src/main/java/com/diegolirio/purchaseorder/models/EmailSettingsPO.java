package com.diegolirio.purchaseorder.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmailSettingsPO {

	@Id @GeneratedValue
	private Long id;
	
	private String host;
	
	private String port;
	
	private String username;
	
	private String password;
	
	@Column(length=100)
	private String fromEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String from) {
		this.fromEmail = from;
	}
	
	
	
}
