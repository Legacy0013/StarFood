package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.CountryRepository;
import com.kymryd.starfood.model.entities.CountryEntity;
import com.kymryd.starfood.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public CountryEntity create(CountryEntity country) {
        return repository.save(country);
    }

    @Override
    public CountryEntity delete(int id) {
        CountryEntity country = findById(id);
        if(country != null){
            repository.delete(country);
        }
        return country;
    }

    @Override
    public List<CountryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CountryEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public CountryEntity update(CountryEntity country) {
        return repository.save(country);
    }
}
