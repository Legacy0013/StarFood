package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.ProductLangEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ProductLangRepository extends CrudRepository<ProductLangEntity, Integer> {

    void delete(ProductLangEntity ProductLang);

    List<ProductLangEntity> findAll();

    ProductLangEntity findById(int id);

    ProductLangEntity save(ProductLangEntity ProductLang);

}

