package com.project.restaurant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.Category;
import com.project.restaurant.repositories.CategoryRepository;

@Service()
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> search() {
		return (List<Category>) categoryRepository.findAll();
	}

	public List<Category> save(Category items) {
		categoryRepository.save(items);
		return (List<Category>) categoryRepository.findAll();
	}

	public List<Category> delete(Category items) {
		categoryRepository.delete(items);
		return (List<Category>) categoryRepository.findAll();
	}

	public List<Category> deleteById(Long id) {
		categoryRepository.deleteById(id);
		return (List<Category>) categoryRepository.findAll();
	}

	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
}
