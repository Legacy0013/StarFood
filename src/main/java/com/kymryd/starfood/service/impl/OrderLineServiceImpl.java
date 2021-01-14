package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.OrderLineRepository;
import com.kymryd.starfood.model.entities.OrderLineEntity;
import com.kymryd.starfood.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository repository;

    @Override
    public OrderLineEntity create(OrderLineEntity orderLine) {
        return repository.save(orderLine);
    }

    @Override
    public OrderLineEntity delete(int id) {
        OrderLineEntity orderLine = findById(id);
        if(orderLine != null){
            repository.delete(orderLine);
        }
        return orderLine;
    }

    @Override
    public List<OrderLineEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderLineEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public OrderLineEntity update(OrderLineEntity orderLine) {
        return repository.save(orderLine);
    }
}
