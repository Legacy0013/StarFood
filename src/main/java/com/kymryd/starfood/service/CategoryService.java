package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity create(CategoryEntity category);

    CategoryEntity delete(int id);

    List<CategoryEntity> findAll();

    CategoryEntity findById(int id);

    CategoryEntity update(CategoryEntity category);

}
