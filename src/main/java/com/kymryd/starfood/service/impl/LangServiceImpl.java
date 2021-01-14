package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.LangRepository;
import com.kymryd.starfood.model.entities.LangEntity;
import com.kymryd.starfood.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangServiceImpl implements LangService {

    @Autowired
    private LangRepository repository;

    @Override
    public LangEntity create(LangEntity Lang) {
        return repository.save(Lang);
    }

    @Override
    public LangEntity delete(int id) {
        LangEntity country = findById(id);
        if(country != null){
            repository.delete(country);
        }
        return country;
    }

    @Override
    public List<LangEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LangEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public LangEntity update(LangEntity Lang) {
        return repository.save(Lang);
    }
}
