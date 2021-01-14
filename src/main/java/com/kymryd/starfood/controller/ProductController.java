package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.ProductEntity;
import com.kymryd.starfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product){
        return productService.create(product);
    }

    @GetMapping(path = {"/{id}"})
    public ProductEntity findOne(@PathVariable("id") int id){
        return productService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public ProductEntity update(@PathVariable("id") int id, @RequestBody ProductEntity product){
        product.setProductId(id);
        return productService.update(product);
    }

    @DeleteMapping(path ={"/{id}"})
    public ProductEntity delete(@PathVariable("id") int id) {
        return productService.delete(id);
    }

    @GetMapping
    public List<ProductEntity> findAll(){
        return productService.findAll();
    }

    @GetMapping(value = {"/status/{statusId}"})
    public List<ProductEntity> findAvailable(@PathVariable("statusId") int statusId) {return productService.findAvailable(statusId);}

@GetMapping(value = {"/ByCategory/{categoryId}"})
    public List<ProductEntity> findByCategory(@PathVariable("categoryId") int categoryId) {return productService.findByCategory(categoryId);}

    @GetMapping(value = {"/ByTypeId/{typeId}"})
    public List<ProductEntity> findByType(@PathVariable("typeId") int typeId) { return productService.findByType(typeId);}
}
