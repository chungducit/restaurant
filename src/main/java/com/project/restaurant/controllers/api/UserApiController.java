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

import com.project.restaurant.models.User;
import com.project.restaurant.services.UserService;

@RequestMapping(path = "/api/user")
@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	// search ALL
	@RequestMapping(method = RequestMethod.GET, path = { "/find" })
	public @ResponseBody List<User> getAllUser() {
		return userService.search();
	}

	// add + update Item
	@RequestMapping(method = RequestMethod.POST, path = { "/add", "/update" })
	public @ResponseBody List<User> addItem(@RequestBody User items) {
		return userService.save(items);
	}

	// delete Item
	// deleteBy entity
	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	public @ResponseBody List<User> deleteItem(@RequestBody User items) {
		return userService.delete(items);
	}

	// deleteBy entity
	@RequestMapping(method = RequestMethod.GET, path = "/deleteById")
	public @ResponseBody List<User> deleteById(@RequestParam Long id) {
		return userService.deleteById(id);
	}

	// findById
	@RequestMapping(method = RequestMethod.GET, path = "/findById")
	public @ResponseBody Optional<User> findById(@RequestParam Long id) {
		return userService.findById(id);
	}

	//findByUserName
	@RequestMapping(method = RequestMethod.GET, path = "/findByUsername")
	public @ResponseBody Iterable<User> findByUsername(@RequestParam String username) {
		return userService.findByUsername(username);
	}
}
