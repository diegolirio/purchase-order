package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.State;

public class StateBuilderTest {

	public static State build() {
		State state = new State();
		state.setAbbreviation("SP");
		state.setName("São Paulo");
		return state;
	}

	
	
}
