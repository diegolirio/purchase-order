package com.diegolirio.purchaseorder.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.StatusType;

@Repository
public interface PurchaseOrderRepositorie extends CrudRepository<PurchaseOrder, Long> {

	List<PurchaseOrder> findByStatusAndEmissionDateBetween(StatusType status, Date dateStart, Date dateEnd);

}
