package com.example.springboot_rest_ajax_practice.repository;

import com.example.springboot_rest_ajax_practice.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
