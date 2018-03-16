package com.project.restaurant.controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.restaurant.models.Category;
import com.project.restaurant.models.Items;
import com.project.restaurant.models.Tables;
import com.project.restaurant.repositories.CategoryRepository;
import com.project.restaurant.repositories.ItemsRepository;
import com.project.restaurant.repositories.TableRepository;
import com.project.restaurant.websocket.SocketController;

@Controller
@RequestMapping(value = "/demo")
public class demo {
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(SocketController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	@GetMapping(value = "/add")
	public @ResponseBody Iterable<Items> addNewUser (@RequestParam String name, @RequestParam String code,
			@RequestParam Double price, @RequestParam Long category_id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Items n = new Items();
		n.setName(name);
		n.setCode(code);
		n.setPrice(price);
		n.setCategoryId(category_id);
		n.setIsDelete(false);
		itemsRepository.save(n);
		return itemsRepository.findAll();
	}
	
	@GetMapping(value = "/all")
	public @ResponseBody Iterable<Tables> getAllTables () {
		return tableRepository.findByName("First");
	}
	
	@RequestMapping(value = "/")
	public String index() {
		return "index2";
	}
	
	@RequestMapping(value = "/t")
	public @ResponseBody String index2() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		System.out.println(timestamp);
		return "index2";
	}
	@RequestMapping(value = "/b")
	public @ResponseBody Iterable<Tables> index_3(@RequestParam String name, @RequestParam String code) {
		Tables t = new Tables();
		
		t.setName(name);
		t.setCode(code);
		tableRepository.save(t);
		
		return tableRepository.findAll();
	}
	
}
