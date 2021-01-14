package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.LocationEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocationRepository extends Repository<LocationEntity, Integer> {

    void delete(LocationEntity location);

    List<LocationEntity> findAll();

    LocationEntity findById(int id);

    LocationEntity save(LocationEntity location);
}
