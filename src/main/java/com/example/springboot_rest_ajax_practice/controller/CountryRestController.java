package com.example.springboot_rest_ajax_practice.controller;

import com.example.springboot_rest_ajax_practice.entity.Country;
import com.example.springboot_rest_ajax_practice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryRestController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }

    @PostMapping("/countries")
    public Country saveCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }
}
