package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.StatusEntity;

import java.util.List;

public interface StatusService {
    StatusEntity create(StatusEntity status);

    StatusEntity delete(int id);

    List<StatusEntity> findAll();

    StatusEntity findById(int id);

    StatusEntity update(StatusEntity status);

}
