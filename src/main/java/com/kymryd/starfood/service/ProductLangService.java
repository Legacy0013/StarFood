package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.ProductLangEntity;

import java.util.List;

public interface ProductLangService {
    ProductLangEntity create(ProductLangEntity ProductLang);

    ProductLangEntity delete(int id);

    List<ProductLangEntity> findAll();

    ProductLangEntity findById(int id);

    ProductLangEntity update(ProductLangEntity ProductLang);

}
