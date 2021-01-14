package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.LangEntity;
import com.kymryd.starfood.service.LangService;
import com.kymryd.starfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/langs")
public class CounterController {

    @Autowired
    private OrderService orderService;

/*    @PostMapping
    public LangEntity create(@RequestBody LangEntity lang) {
        return orderService.create(lang);
    }

    @GetMapping(path = {"/{id}"})
    public LangEntity findOne(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public LangEntity update(@PathVariable("id") int id, @RequestBody LangEntity lang) {
        lang.setLangId(id);
        return orderService.update(lang);
    }

    @DeleteMapping(path = {"/{id}"})
    public LangEntity delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping
    public List<LangEntity> findAll() {
        return orderService.findAll();
    }*/
}
