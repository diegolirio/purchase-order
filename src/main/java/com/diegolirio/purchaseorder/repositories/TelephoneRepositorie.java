package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Telephone;

@Repository
public interface TelephoneRepositorie extends CrudRepository<Telephone, Long> {

}
