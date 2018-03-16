package com.project.restaurant.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.restaurant.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	Iterable<Category> findByParentId(Long parentId);
}
