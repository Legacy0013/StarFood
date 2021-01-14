package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.ProductTypeEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductTypeRepository extends Repository<ProductTypeEntity, Integer> {

    void delete(ProductTypeEntity productType);

    List<ProductTypeEntity> findAll();

    ProductTypeEntity findById(int id);

    ProductTypeEntity save(ProductTypeEntity productType);
}
