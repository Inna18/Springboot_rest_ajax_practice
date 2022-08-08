package com.example.springboot_rest_ajax_practice.country;

import com.example.springboot_rest_ajax_practice.entity.Country;
import com.example.springboot_rest_ajax_practice.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CountryRepositoryTests {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void testCreateNewCountry() {
        Country savedCountry = countryRepository.save(new Country("South Korea"));

        assertNotNull(savedCountry);
        assertTrue(savedCountry.getId() > 0);
    }

    @Test
    public void testGetCountryList() {
        List<Country> countryList = countryRepository.findAll();

        for (Country country : countryList) {
            System.out.println(country.getName());
        }

        assertThat(countryList).isNotEmpty();
    }
}
