package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.User;
import com.diegolirio.purchaseorder.repositories.userRepository;

@Service
public class UserService {

	@Autowired
	private userRepository userRepository;

	public User login(String login, String password) {
		return this.userRepository.findByLoginAndPassword(login, password);
	}

}
