package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.RecipeRepository;
import com.kymryd.starfood.model.entities.RecipeEntity;
import com.kymryd.starfood.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository repository;

    @Override
    public RecipeEntity create(RecipeEntity recipe) {
        return repository.save(recipe);
    }

    @Override
    public RecipeEntity delete(int id) {
        RecipeEntity recipe = findById(id);
        if(recipe != null){
            repository.delete(recipe);
        }
        return recipe;
    }

    @Override
    public List<RecipeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public RecipeEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public RecipeEntity update(RecipeEntity recipe) {
        return repository.save(recipe);
    }
}
