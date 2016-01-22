package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.State;

public class StateBuilder {

	private String abbreviation;
	private Long id;
	private String name;

	public StateBuilder withAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	
	public StateBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public StateBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public State build() {
		State state = new State();
		state.setAbbreviation(abbreviation);
		state.setId(id);
		state.setName(name);
		return state ;
	}
	
}
