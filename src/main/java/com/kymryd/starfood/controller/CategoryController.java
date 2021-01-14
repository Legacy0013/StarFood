package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.CategoryEntity;
import com.kymryd.starfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryEntity create(@RequestBody CategoryEntity category){
        return categoryService.create(category);
    }

    @GetMapping(path = {"/{id}"})
    public CategoryEntity findOne(@PathVariable("id") int id){
        return categoryService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public CategoryEntity update(@PathVariable("id") int id, @RequestBody CategoryEntity category){
        category.setCategoryId(id);
        return categoryService.update(category);
    }

    @DeleteMapping(path ={"/{id}"})
    public CategoryEntity delete(@PathVariable("id") int id) {
        return categoryService.delete(id);
    }

    @GetMapping
    public List<CategoryEntity> findAll(){
        return categoryService.findAll();
    }


}
