package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.LangEntity;
import com.kymryd.starfood.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/langs")
public class LangController {

    @Autowired
    private LangService langService;

    @PostMapping
    public LangEntity create(@RequestBody LangEntity lang) {
        return langService.create(lang);
    }

    @GetMapping(path = {"/{id}"})
    public LangEntity findOne(@PathVariable("id") int id) {
        return langService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public LangEntity update(@PathVariable("id") int id, @RequestBody LangEntity lang) {
        lang.setLangId(id);
        return langService.update(lang);
    }

    @DeleteMapping(path = {"/{id}"})
    public LangEntity delete(@PathVariable("id") int id) {
        return langService.delete(id);
    }

    @GetMapping
    public List<LangEntity> findAll() {
        return langService.findAll();
    }
}
