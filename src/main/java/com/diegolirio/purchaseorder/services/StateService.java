package com.diegolirio.purchaseorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.State;
import com.diegolirio.purchaseorder.repositories.StateRepositorie;

@Service
public class StateService {

	@Autowired
	private StateRepositorie stateRepositorie;

	public Iterable<State> getAll() {
		return this.stateRepositorie.findAll();
	}

	
	
}
