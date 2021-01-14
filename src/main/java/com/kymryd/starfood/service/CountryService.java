package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.CountryEntity;

import java.util.List;

public interface CountryService {
    CountryEntity create(CountryEntity country);

    CountryEntity delete(int id);

    List<CountryEntity> findAll();

    CountryEntity findById(int id);

    CountryEntity update(CountryEntity country);

}
