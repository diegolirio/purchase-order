package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Telephone;

public class TelephoneBuilderTest {


	private static final String CONTACT_TYPE_COMERCIAL = "COMERCIAL";
	private static final String TELEFONE_COMERCIAL = "(11) 96140-9798";

	public static Telephone builderTest() {
		TelephoneBuilder telephoneBuilder = new TelephoneBuilder();
		Telephone telephone = telephoneBuilder.withContactType(CONTACT_TYPE_COMERCIAL)
											  .withNumber(TELEFONE_COMERCIAL)
											  .build();
		return telephone;
	}
	
}
