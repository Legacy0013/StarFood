package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.StockRepository;
import com.kymryd.starfood.model.entities.StockEntity;
import com.kymryd.starfood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository repository;

    @Override
    public StockEntity create(StockEntity stock) {
        return repository.save(stock);
    }

    @Override
    public StockEntity delete(int id) {
        StockEntity stock = findById(id);
        if(stock != null){
            repository.delete(stock);
        }
        return stock;
    }

    @Override
    public List<StockEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public StockEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public StockEntity update(StockEntity stock) {
        return repository.save(stock);
    }
}
