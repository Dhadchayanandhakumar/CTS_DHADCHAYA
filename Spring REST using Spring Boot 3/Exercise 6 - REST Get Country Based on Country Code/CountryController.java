package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private final CountryService service = new CountryService();

    @RequestMapping("/country")
    public Country getCountryIndia() {

        return new Country("IN", "India");
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        return service.getCountry(code);
    }
}