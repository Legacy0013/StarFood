package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.UserEntity;
import com.kymryd.starfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity create(@RequestBody UserEntity user){
        return userService.create(user);
    }

    @GetMapping(path = {"/{id}"})
    public UserEntity findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public UserEntity update(@PathVariable("id") int id, @RequestBody UserEntity user){
        user.setUserId(id);
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public UserEntity delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<UserEntity> findAll(){
        return userService.findAll();
    }


}
