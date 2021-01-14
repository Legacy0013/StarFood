package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity create(RoleEntity role);

    RoleEntity delete(int id);

    List<RoleEntity> findAll();

    RoleEntity findById(int id);

    RoleEntity update(RoleEntity role);

}
