package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.MenuEntity;
import com.kymryd.starfood.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public MenuEntity create(@RequestBody MenuEntity menu){
        return menuService.create(menu);
    }

    @GetMapping(path = {"/{id}"})
    public MenuEntity findOne(@PathVariable("id") int id){
        return menuService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public MenuEntity update(@PathVariable("id") int id, @RequestBody MenuEntity menu){
        menu.setMenuId(id);
        return menuService.update(menu);
    }

    @DeleteMapping(path ={"/{id}"})
    public MenuEntity delete(@PathVariable("id") int id) {
        return menuService.delete(id);
    }

    @GetMapping
    public List<MenuEntity> findAll(){
        return menuService.findAll();
    }


}
