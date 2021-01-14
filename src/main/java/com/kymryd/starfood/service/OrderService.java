package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity create(OrderEntity order);

    OrderEntity delete(int id);

    List<OrderEntity> findAll();

    OrderEntity findById(int id);

    OrderEntity update(OrderEntity order);

}
