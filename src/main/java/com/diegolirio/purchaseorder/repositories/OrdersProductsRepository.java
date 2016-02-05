package com.diegolirio.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.PurchaseOrder;

@Repository
public interface OrdersProductsRepository extends CrudRepository<OrdersProducts, Long> {

	public List<OrdersProducts> findByPurchaseOrder(PurchaseOrder purchaseOrder);

}
