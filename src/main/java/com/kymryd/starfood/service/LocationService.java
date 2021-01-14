package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.LocationEntity;

import java.util.List;

public interface LocationService {
    LocationEntity create(LocationEntity location);

    LocationEntity delete(int id);

    List<LocationEntity> findAll();

    LocationEntity findById(int id);

    LocationEntity update(LocationEntity location);

}
