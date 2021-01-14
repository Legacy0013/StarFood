package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.ProductLangEntity;
import com.kymryd.starfood.service.ProductLangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/productLangs")
public class ProductLangController {

    @Autowired
    private ProductLangService productLangService;

    @PostMapping
    public ProductLangEntity create(@RequestBody ProductLangEntity productLang){
        return productLangService.create(productLang);
    }

    @GetMapping(path = {"/{id}"})
    public ProductLangEntity findOne(@PathVariable("id") int id){
        return productLangService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public ProductLangEntity update(@PathVariable("id") int id, @RequestBody ProductLangEntity productLang){
        productLang.setProductId(id);
        return productLangService.update(productLang);
    }

    @DeleteMapping(path ={"/{id}"})
    public ProductLangEntity delete(@PathVariable("id") int id) {
        return productLangService.delete(id);
    }

    @GetMapping
    public List<ProductLangEntity> findAll(){
        return productLangService.findAll();
    }
}
