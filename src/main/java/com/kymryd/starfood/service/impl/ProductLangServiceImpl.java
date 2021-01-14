package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.ProductLangRepository;
import com.kymryd.starfood.model.entities.ProductLangEntity;
import com.kymryd.starfood.service.ProductLangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLangServiceImpl implements ProductLangService {

    @Autowired
    private ProductLangRepository repository;

    @Override
    public ProductLangEntity create(ProductLangEntity ProductLang) {
        return repository.save(ProductLang);
    }

    @Override
    public ProductLangEntity delete(int id) {
        ProductLangEntity ProductLang = findById(id);
        if(ProductLang != null){
            repository.delete(ProductLang);
        }
        return ProductLang;
    }

    @Override
    public List<ProductLangEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductLangEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ProductLangEntity update(ProductLangEntity ProductLang) {
        return repository.save(ProductLang);
    }

}
