package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.ProductTypeEntity;

import java.util.List;

public interface ProductTypeService {
    ProductTypeEntity create(ProductTypeEntity productType);

    ProductTypeEntity delete(int id);

    List<ProductTypeEntity> findAll();

    ProductTypeEntity findById(int id);

    ProductTypeEntity update(ProductTypeEntity productType);

}
