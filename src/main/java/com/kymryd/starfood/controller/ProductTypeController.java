package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.ProductTypeEntity;
import com.kymryd.starfood.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/productTypes")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping
    public ProductTypeEntity create(@RequestBody ProductTypeEntity productType){
        return productTypeService.create(productType);
    }

    @GetMapping(path = {"/{id}"})
    public ProductTypeEntity findOne(@PathVariable("id") int id){
        return productTypeService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public ProductTypeEntity update(@PathVariable("id") int id, @RequestBody ProductTypeEntity productType){
        productType.setProductTypeId(id);
        return productTypeService.update(productType);
    }

    @DeleteMapping(path ={"/{id}"})
    public ProductTypeEntity delete(@PathVariable("id") int id) {
        return productTypeService.delete(id);
    }

    @GetMapping
    public List<ProductTypeEntity> findAll(){
        return productTypeService.findAll();
    }


}
