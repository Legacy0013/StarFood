package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.StockEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StockRepository extends Repository<StockEntity, Integer> {

    void delete(StockEntity stock);

    List<StockEntity> findAll();

    StockEntity findById(int id);

    StockEntity save(StockEntity stock);
}
