package br.com.cafglass.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cafglass.purchaseorder.models.State;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

	State findByAbbreviation(String abbreviation);

}
