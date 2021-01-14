package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.OrderRepository;
import com.kymryd.starfood.model.entities.OrderEntity;
import com.kymryd.starfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public OrderEntity create(OrderEntity order) {
        return repository.save(order);
    }

    @Override
    public OrderEntity delete(int id) {
        OrderEntity order = findById(id);
        if(order != null){
            repository.delete(order);
        }
        return order;
    }

    @Override
    public List<OrderEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public OrderEntity update(OrderEntity order) {
        return repository.save(order);
    }
}
