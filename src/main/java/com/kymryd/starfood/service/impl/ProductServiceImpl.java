package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.ProductRepository;
import com.kymryd.starfood.model.entities.ProductEntity;
import com.kymryd.starfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductEntity create(ProductEntity Product) {
        return repository.save(Product);
    }

    @Override
    public ProductEntity delete(int id) {
        ProductEntity Product = findById(id);
        if(Product != null){
            repository.delete(Product);
        }
        return Product;
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ProductEntity update(ProductEntity Product) {
        return repository.save(Product);
    }

    @Override
    public List<ProductEntity> findAvailable(int statusId) {
        return repository.findByStatusId(statusId);
    }

    @Override
    public List<ProductEntity> findByCategory(int categoryId) { return repository.findByCategoryId(categoryId); }

    @Override
    public List<ProductEntity> findByType(int typeId) {
        return repository.findByProductTypeId(typeId);
    }
}
