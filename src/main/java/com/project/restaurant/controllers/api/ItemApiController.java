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

import com.project.restaurant.models.Items;
import com.project.restaurant.models.business.CategoryInfo;
import com.project.restaurant.services.ItemService;

@RestController
@RequestMapping(value = "/api/v1")
public class ItemApiController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/getitems")
	public List<CategoryInfo> getAllReservationsForDate() {
		return itemService.getAllItemInfo();
	}

	// add + update Item
	@RequestMapping(method = RequestMethod.POST, path = { "/addItem", "/updateItem" })
	public @ResponseBody List<Items> addItem(@RequestBody Items items) {
		return itemService.saveItem(items);
	}

	// delete Item
	// deleteBy entity
	@RequestMapping(method = RequestMethod.POST, path = "/deleteItem")
	public @ResponseBody List<Items> deleteItem(@RequestBody Items items) {
		return itemService.deleteItem(items);
	}

	// deleteBy entity
	@RequestMapping(method = RequestMethod.GET, path = "/deleteItemById")
	public @ResponseBody List<Items> deleteItemById(@RequestParam Long id) {
		return itemService.deleteItemById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getById")
	public @ResponseBody Optional<Items> getById(@RequestParam Long id) {
		return itemService.getById(id);
	}
}
