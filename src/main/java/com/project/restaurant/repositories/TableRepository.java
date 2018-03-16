package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.Tables;

@Repository
public interface TableRepository extends CrudRepository<Tables, Long> {
	Iterable<Tables> findByName(String name);
	Long countByName(String name);
}