package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity create(ProductEntity Product);

    ProductEntity delete(int id);

    List<ProductEntity> findAll();

    ProductEntity findById(int id);

    ProductEntity update(ProductEntity Product);

    List<ProductEntity> findAvailable(int statusId);

    List<ProductEntity> findByCategory(int ctageoryId);


    List<ProductEntity> findByType(int typeId);
}
