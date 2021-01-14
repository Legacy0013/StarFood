package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.RecipeEntity;

import java.util.List;

public interface RecipeService {
    RecipeEntity create(RecipeEntity recipe);

    RecipeEntity delete(int id);

    List<RecipeEntity> findAll();

    RecipeEntity findById(int id);

    RecipeEntity update(RecipeEntity recipe);

}
