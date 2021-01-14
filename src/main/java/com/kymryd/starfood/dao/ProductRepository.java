package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    void delete(ProductEntity Product);

    List<ProductEntity> findAll();

    ProductEntity findById(int id);

    ProductEntity save(ProductEntity Product);

    List<ProductEntity> findByStatusId(int statusId);

    List<ProductEntity> findByCategoryId(int categoryId);

    List<ProductEntity> findByProductTypeId(int typeId);
}

