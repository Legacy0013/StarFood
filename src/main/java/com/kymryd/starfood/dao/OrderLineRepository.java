package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.OrderLineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderLineRepository extends CrudRepository<OrderLineEntity, Integer> {

    void delete(OrderLineEntity orderLine);

    List<OrderLineEntity> findAll();

    OrderLineEntity findById(int id);

    OrderLineEntity save(OrderLineEntity orderLine);
}
