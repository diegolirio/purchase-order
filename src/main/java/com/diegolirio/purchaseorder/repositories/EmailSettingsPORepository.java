package com.diegolirio.purchaseorder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.purchaseorder.models.EmailSettingsPO;

@Repository
public interface EmailSettingsPORepository extends CrudRepository<EmailSettingsPO, Long> {

}
