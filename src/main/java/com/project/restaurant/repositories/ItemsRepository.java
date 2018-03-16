package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.Items;

@Repository
public interface ItemsRepository extends CrudRepository<Items, Long>{
	Iterable<Items> findByCategoryId(Long categoryId);
}
