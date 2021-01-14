package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.LocationRepository;
import com.kymryd.starfood.model.entities.LocationEntity;
import com.kymryd.starfood.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public LocationEntity create(LocationEntity location) {
        return repository.save(location);
    }

    @Override
    public LocationEntity delete(int id) {
        LocationEntity location = findById(id);
        if(location != null){
            repository.delete(location);
        }
        return location;
    }

    @Override
    public List<LocationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LocationEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public LocationEntity update(LocationEntity location) {
        return repository.save(location);
    }
}
