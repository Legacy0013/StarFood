package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.LocationEntity;
import com.kymryd.starfood.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public LocationEntity create(@RequestBody LocationEntity location){
        return locationService.create(location);
    }

    @GetMapping(path = {"/{id}"})
    public LocationEntity findOne(@PathVariable("id") int id){
        return locationService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public LocationEntity update(@PathVariable("id") int id, @RequestBody LocationEntity location){
        location.setLocationId(id);
        return locationService.update(location);
    }

    @DeleteMapping(path ={"/{id}"})
    public LocationEntity delete(@PathVariable("id") int id) {
        return locationService.delete(id);
    }

    @GetMapping
    public List<LocationEntity> findAll(){
        return locationService.findAll();
    }


}
