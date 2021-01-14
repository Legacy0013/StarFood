package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.RecipeEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RecipeRepository extends Repository<RecipeEntity, Integer> {

    void delete(RecipeEntity recipe);

    List<RecipeEntity> findAll();

    RecipeEntity findById(int id);

    RecipeEntity save(RecipeEntity recipe);
}
