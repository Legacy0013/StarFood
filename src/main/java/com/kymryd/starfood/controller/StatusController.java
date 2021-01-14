package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.StatusEntity;
import com.kymryd.starfood.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public StatusEntity create(@RequestBody StatusEntity status){
        return statusService.create(status);
    }

    @GetMapping(path = {"/{id}"})
    public StatusEntity findOne(@PathVariable("id") int id){
        return statusService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public StatusEntity update(@PathVariable("id") int id, @RequestBody StatusEntity status){
        status.setStatusId(id);
        return statusService.update(status);
    }

    @DeleteMapping(path ={"/{id}"})
    public StatusEntity delete(@PathVariable("id") int id) {
        return statusService.delete(id);
    }

    @GetMapping
    public List<StatusEntity> findAll(){
        return statusService.findAll();
    }


}
