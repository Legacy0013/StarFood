package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.RoleEntity;
import com.kymryd.starfood.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public RoleEntity create(@RequestBody RoleEntity role){
        return roleService.create(role);
    }

    @GetMapping(path = {"/{id}"})
    public RoleEntity findOne(@PathVariable("id") int id){
        return roleService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public RoleEntity update(@PathVariable("id") int id, @RequestBody RoleEntity role){
        role.setRoleId(id);
        return roleService.update(role);
    }

    @DeleteMapping(path ={"/{id}"})
    public RoleEntity delete(@PathVariable("id") int id) {
        return roleService.delete(id);
    }

    @GetMapping
    public List<RoleEntity> findAll(){
        return roleService.findAll();
    }


}
