package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.CountryEntity;
import com.kymryd.starfood.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public CountryEntity create(@RequestBody CountryEntity country){
        return countryService.create(country);
    }

    @GetMapping(path = {"/{id}"})
    public CountryEntity findOne(@PathVariable("id") int id){
        return countryService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public CountryEntity update(@PathVariable("id") int id, @RequestBody CountryEntity country){
        country.setCountryId(id);
        return countryService.update(country);
    }

    @DeleteMapping(path ={"/{id}"})
    public CountryEntity delete(@PathVariable("id") int id) {
        return countryService.delete(id);
    }

    @GetMapping
    public List<CountryEntity> findAll(){
        return countryService.findAll();
    }


}
