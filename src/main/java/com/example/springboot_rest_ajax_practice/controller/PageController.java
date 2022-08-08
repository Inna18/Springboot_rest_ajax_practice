package com.example.springboot_rest_ajax_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String form() {
        return "country_state";
    }
}
