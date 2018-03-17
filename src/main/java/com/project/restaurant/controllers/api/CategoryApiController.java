package com.project.restaurant.controllers.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.restaurant.models.Category;
import com.project.restaurant.services.CategoryService;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryApiController {

	@Autowired
	private CategoryService categoryService;
// search ALL
	@RequestMapping(method = RequestMethod.GET,path = {"/find"})
	public @ResponseBody List<Category> getAllCategory() {
		return categoryService.search();
	}
//  add + update Item
  @RequestMapping(method = RequestMethod.POST,path = {"/add","/update"})
  public @ResponseBody List<Category> addItem(@RequestBody  Category items) {
		return categoryService.save(items);
	}
//delete Item
//  deleteBy entity
  @RequestMapping(method = RequestMethod.POST,path = "/delete")
  public @ResponseBody List<Category> deleteItem(@RequestBody  Category items) {
		return categoryService.delete(items);
	}
  
//deleteBy entity
@RequestMapping(method = RequestMethod.GET,path = "/deleteById")
public @ResponseBody List<Category> deleteById(@RequestParam Long id) {
		return categoryService.deleteById(id);
	}

//findById
@RequestMapping(method = RequestMethod.GET,path = "/findById")
public @ResponseBody Optional<Category> findById(@RequestParam Long id) {
		return categoryService.findById(id);
	}
}
