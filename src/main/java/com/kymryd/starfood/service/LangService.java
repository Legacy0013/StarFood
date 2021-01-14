package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.LangEntity;

import java.util.List;

public interface LangService {
    LangEntity create(LangEntity Lang);

    LangEntity delete(int id);

    List<LangEntity> findAll();

    LangEntity findById(int id);

    LangEntity update(LangEntity Lang);
}
