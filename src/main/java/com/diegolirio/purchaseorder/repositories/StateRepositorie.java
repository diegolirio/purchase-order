package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.State;

@Repository
public interface StateRepositorie extends CrudRepository<State, Long> {

}
