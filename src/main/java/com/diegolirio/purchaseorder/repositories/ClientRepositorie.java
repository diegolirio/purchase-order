package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.Client;

@Repository
public interface ClientRepositorie extends CrudRepository<Client, Long> {

}
