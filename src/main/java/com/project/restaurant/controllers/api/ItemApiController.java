package com.project.restaurant.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
