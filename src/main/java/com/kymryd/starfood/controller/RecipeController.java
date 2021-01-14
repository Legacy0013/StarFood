package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.RecipeEntity;
import com.kymryd.starfood.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public RecipeEntity create(@RequestBody RecipeEntity recipe){
        return recipeService.create(recipe);
    }

    @GetMapping(path = {"/{id}"})
    public RecipeEntity findOne(@PathVariable("id") int id){
        return recipeService.findById(id);
    }

/*    @PutMapping(path = {"/{id}"})
    public RecipeEntity update(@PathVariable("id") int id, @RequestBody RecipeEntity recipe){
        recipe.setRecipeId(id);
        return recipeService.update(recipe);
    }*/

    @DeleteMapping(path ={"/{id}"})
    public RecipeEntity delete(@PathVariable("id") int id) {
        return recipeService.delete(id);
    }

    @GetMapping
    public List<RecipeEntity> findAll(){
        return recipeService.findAll();
    }


}
