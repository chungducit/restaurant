package com.project.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
    @GetMapping("createitem")
    public String index() {
        return "createitem";
    }
}
