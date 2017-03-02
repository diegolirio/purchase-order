package br.com.cafglass.purchaseorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cafglass.purchaseorder.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

	List<Address> findByPeopleId(Long peopleId);

}
