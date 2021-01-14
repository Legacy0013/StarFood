package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

    void delete(OrderEntity order);

    List<OrderEntity> findAll();

    OrderEntity findById(int id);

    OrderEntity save(OrderEntity order);
}
