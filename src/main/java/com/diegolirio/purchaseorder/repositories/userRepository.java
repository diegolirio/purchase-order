package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {

	User findByLoginAndPassword(String login, String password);
 
}
