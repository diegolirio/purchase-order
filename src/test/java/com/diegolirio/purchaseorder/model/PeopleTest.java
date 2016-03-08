package com.diegolirio.purchaseorder.model;

import org.junit.Assert;
import org.junit.Test;

import com.diegolirio.purchaseorder.models.People;

public class PeopleTest {

	@Test
	public void testCpfCnpj() {
		People p = new People();
		p.setCpfCnpj("61.139.432/0001-69");
		Assert.assertEquals("CPF/CNPJ deve conter somente numeros", "61139432000169", p.getCpfCnpj());
	}
	
}
