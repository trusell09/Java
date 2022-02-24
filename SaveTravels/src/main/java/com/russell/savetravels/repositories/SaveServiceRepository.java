package com.russell.savetravels.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.russell.savetravels.models.SaveService;

//  REPOSITORIES HAVE DIRECT ACCESS TO OUR MYSQL DB
@Repository
public interface SaveServiceRepository extends CrudRepository<SaveService, Long> {

}
