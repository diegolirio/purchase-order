package com.diegolirio.purchaseorder.builder;

import com.diegolirio.purchaseorder.models.Product;

public class ProductBuilderTest {
	
	private static final String PRODUCT_CODE = "35970";
	private static final String PRODUCT_DESCRIPTION = "Product Test";
	private static final double PRODUCT_VALUEUNIT = 1000d;

	public static Product buildTest() {
		ProductBuilder prodBuilder = new ProductBuilder();
		Product product = prodBuilder.withCode(PRODUCT_CODE)
								     .withDescription(PRODUCT_DESCRIPTION)
								     .withValueUnit(PRODUCT_VALUEUNIT)
								     .build();
		return product;
	}
	
}
