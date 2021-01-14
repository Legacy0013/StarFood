package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.StockEntity;
import com.kymryd.starfood.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public StockEntity create(@RequestBody StockEntity stock){
        return stockService.create(stock);
    }

    @GetMapping(path = {"/{id}"})
    public StockEntity findOne(@PathVariable("id") int id){
        return stockService.findById(id);
    }

/*    @PutMapping(path = {"/{id}"})
    public StockEntity update(@PathVariable("id") int id, @RequestBody StockEntity stock){
        stock.setStockId(id);
        return stockService.update(stock);
    }*/

    @DeleteMapping(path ={"/{id}"})
    public StockEntity delete(@PathVariable("id") int id) {
        return stockService.delete(id);
    }

    @GetMapping
    public List<StockEntity> findAll(){
        return stockService.findAll();
    }


}
