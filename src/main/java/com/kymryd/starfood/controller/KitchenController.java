package com.kymryd.starfood.controller;


import com.kymryd.starfood.model.entities.OrderEntity;
import com.kymryd.starfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = {"/{id}"})
    public OrderEntity findOne(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public OrderEntity update(@PathVariable("id") int id, @RequestBody OrderEntity order) {
        order.setOrderId(id);
        return orderService.update(order);
    }

    @DeleteMapping(path = {"/{id}"})
    public OrderEntity delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping
    public List<OrderEntity> findAll() {
        return orderService.findAll();
    }
}
