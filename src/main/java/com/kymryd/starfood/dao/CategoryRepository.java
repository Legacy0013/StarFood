package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.CategoryEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CategoryRepository extends Repository<CategoryEntity, Integer> {

    void delete(CategoryEntity category);

    List<CategoryEntity> findAll();

    CategoryEntity findById(int id);

    CategoryEntity save(CategoryEntity category);
}
