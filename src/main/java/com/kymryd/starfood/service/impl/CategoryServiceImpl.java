package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.CategoryRepository;
import com.kymryd.starfood.model.entities.CategoryEntity;
import com.kymryd.starfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public CategoryEntity create(CategoryEntity category) {
        return repository.save(category);
    }

    @Override
    public CategoryEntity delete(int id) {
        CategoryEntity category = findById(id);
        if(category != null){
            repository.delete(category);
        }
        return category;
    }

    @Override
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CategoryEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public CategoryEntity update(CategoryEntity category) {
        return repository.save(category);
    }
}
