package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.OrderLineEntity;
import com.kymryd.starfood.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orderLines")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @PostMapping
    public OrderLineEntity create(@RequestBody OrderLineEntity orderLine){
        return orderLineService.create(orderLine);
    }

    @GetMapping(path = {"/{id}"})
    public OrderLineEntity findOne(@PathVariable("id") int id){
        return orderLineService.findById(id);
    }

/*    @PutMapping(path = {"/{id}"})
    public OrderLineEntity update(@PathVariable("id") int id, @RequestBody OrderLineEntity orderLine){
        orderLine.setOrderLineId(id);
        return orderLineService.update(orderLine);
    }*/

    @DeleteMapping(path ={"/{id}"})
    public OrderLineEntity delete(@PathVariable("id") int id) {
        return orderLineService.delete(id);
    }

    @GetMapping
    public List<OrderLineEntity> findAll(){
        return orderLineService.findAll();
    }


}
