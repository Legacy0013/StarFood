package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.RoleEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoleRepository extends Repository<RoleEntity, Integer> {

    void delete(RoleEntity role);

    List<RoleEntity> findAll();

    RoleEntity findById(int id);

    RoleEntity save(RoleEntity role);
}
