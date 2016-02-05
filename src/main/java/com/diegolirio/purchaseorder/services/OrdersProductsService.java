package com.diegolirio.purchaseorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.repositories.OrdersProductsRepository;

@Service
public class OrdersProductsService {

	@Autowired
	private OrdersProductsRepository ordersProductsRepository;

	public OrdersProducts save(OrdersProducts orderProduct) {
		return this.ordersProductsRepository.save(orderProduct);
	}

	public List<OrdersProducts> getListByPurchaseOrder(PurchaseOrder purchaseOrder) {
		return this.ordersProductsRepository.findByPurchaseOrder(purchaseOrder);
	}

	public void delete(long id) {
		this.ordersProductsRepository.delete(id);
	}

}
