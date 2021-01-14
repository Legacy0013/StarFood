package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.ProductTypeRepository;
import com.kymryd.starfood.model.entities.ProductTypeEntity;
import com.kymryd.starfood.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository repository;

    @Override
    public ProductTypeEntity create(ProductTypeEntity productType) {
        return repository.save(productType);
    }

    @Override
    public ProductTypeEntity delete(int id) {
        ProductTypeEntity productType = findById(id);
        if(productType != null){
            repository.delete(productType);
        }
        return productType;
    }

    @Override
    public List<ProductTypeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductTypeEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ProductTypeEntity update(ProductTypeEntity productType) {
        return repository.save(productType);
    }
}
