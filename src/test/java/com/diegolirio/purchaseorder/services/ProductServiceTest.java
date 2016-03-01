package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.diegolirio.purchaseorder.builder.ProductBuilderTest;
import com.diegolirio.purchaseorder.models.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
@Transactional
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	private Product product;

	@Before
	public void before() {
		product = ProductBuilderTest.buildTest();
	}
	
	@Test
	public void testProductSaveInsert() {
		productService.save(product);
		Assert.assertTrue(product.getId() > 0);
	}
	
	
	/**
	 * Deve bloquear clientes cadastrado com cpfCnpj igual que estão ativos
	 */
	@Test
	public void testProductUpdate() {
		product = productService.save(product);
		Long id = product.getId();
		Assert.assertTrue(product.getId() > 0);
		product.setValueUnit(1d);
		product = productService.save(product);
		Assert.assertTrue(product.getId() > 0);
		Assert.assertTrue(product.getValueUnit() == 1d);
		Assert.assertNotEquals("ID do inserido deve ser diferente do alterado!", id, product.getId());
		Product productDesactive = this.productService.get(id);
		Assert.assertNull("Produto deve ter sido excluido (null)", productDesactive);
	}
	
	@Test
	public void test() {
		productService.save(product);
		Assert.assertTrue(product.getId() > 0);
		List<Product> all = this.productService.getAll();
		Assert.assertTrue(all.size() > 0);
	}
	
	/*
	 *  TODO: test deve inserir um produto e vincular em uma P.O e depois alterar, deve ter o id diferente da antes de alterar com 
	 *         o id alterado, e o produto antes de alterado deve fazer uma busca por id e estar desativado!!! 
	 */
	
	/*
	 * TODO: test deve lista todos os produtos somente ativos
	 */
	
}
