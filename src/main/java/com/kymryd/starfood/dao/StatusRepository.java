package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.StatusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<StatusEntity, Integer> {

    void delete(StatusEntity status);

    List<StatusEntity> findAll();

    StatusEntity findById(int id);

    StatusEntity save(StatusEntity status);
}

