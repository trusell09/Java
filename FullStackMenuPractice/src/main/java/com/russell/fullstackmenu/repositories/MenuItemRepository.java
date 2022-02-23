package com.russell.fullstackmenu.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.russell.fullstackmenu.models.MenuItem;

// REPOSITORIES HAVE DIRECT ACCESS TO OUR MYSQL DB
@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long>{

}
