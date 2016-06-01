package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.EmailSettingsPO;
import com.diegolirio.purchaseorder.repositories.EmailSettingsPORepository;

@Service
public class EmailSettingsPOService {

	@Autowired
	private EmailSettingsPORepository emailSettingsPORepository;

	public EmailSettingsPO getMain() {
		return this.emailSettingsPORepository.findOne(1l);
	}

	public EmailSettingsPO save(EmailSettingsPO emailSettingsPO) {
		return this.emailSettingsPORepository.save(emailSettingsPO);
	}

}
