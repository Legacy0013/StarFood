package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.LangEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LangRepository extends Repository<LangEntity, Integer> {

    void delete(LangEntity Lang);

    List<LangEntity> findAll();

    LangEntity findById(int id);

    LangEntity save(LangEntity Lang);
}
