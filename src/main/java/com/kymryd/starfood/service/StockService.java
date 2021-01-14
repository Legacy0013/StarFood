package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.StockEntity;

import java.util.List;

public interface StockService {
    StockEntity create(StockEntity stock);

    StockEntity delete(int id);

    List<StockEntity> findAll();

    StockEntity findById(int id);

    StockEntity update(StockEntity stock);

}
