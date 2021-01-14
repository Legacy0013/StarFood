package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.OrderLineEntity;

import java.util.List;

public interface OrderLineService {
    OrderLineEntity create(OrderLineEntity orderLine);

    OrderLineEntity delete(int id);

    List<OrderLineEntity> findAll();

    OrderLineEntity findById(int id);

    OrderLineEntity update(OrderLineEntity orderLine);

}
