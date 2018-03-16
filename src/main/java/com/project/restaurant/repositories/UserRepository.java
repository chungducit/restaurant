package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
