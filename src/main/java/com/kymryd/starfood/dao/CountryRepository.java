package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.CountryEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CountryRepository extends Repository<CountryEntity, Integer> {

    void delete(CountryEntity country);

    List<CountryEntity> findAll();

    CountryEntity findById(int id);

    CountryEntity save(CountryEntity country);
}
