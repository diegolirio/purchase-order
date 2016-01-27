package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.PurchaseOrder;

@Repository("purchaseOrderRepositorie")
public interface PurchaseOrderRepositorie extends CrudRepository<PurchaseOrder, Long> {

}
