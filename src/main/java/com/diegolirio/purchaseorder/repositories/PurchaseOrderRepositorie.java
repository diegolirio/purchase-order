package com.diegolirio.purchaseorder.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.PurchaseOrder;

@Repository
public interface PurchaseOrderRepositorie extends CrudRepository<PurchaseOrder, Long> {

	PurchaseOrder findByStatusAndEmissionDateBetween(String status, Date dateStart, Date dateEnd);

}
