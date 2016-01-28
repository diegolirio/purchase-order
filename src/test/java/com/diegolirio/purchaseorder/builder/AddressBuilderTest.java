package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Address;

public class AddressBuilderTest {

	public static Address buildTest() {
		AddressBuilder adderssBuilder = new AddressBuilder();
		Address address = adderssBuilder.withCep("07503270")
					   		    .withCity("São Paulo")
							    .withNeighborhood("Parque Novo Mundo")
							    .withNumber(22)
							    .withPublicPlace("Rua Lidice")
							    .build();
		return address;
	}
	
}
