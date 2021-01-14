package com.kymryd.starfood.controller;

import com.kymryd.starfood.model.entities.OfferEntity;
import com.kymryd.starfood.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping
    public OfferEntity create(@RequestBody OfferEntity offer){
        return offerService.create(offer);
    }

    @GetMapping(path = {"/{id}"})
    public OfferEntity findOne(@PathVariable("id") int id){
        return offerService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public OfferEntity update(@PathVariable("id") int id, @RequestBody OfferEntity offer){
        offer.setOfferId(id);
        return offerService.update(offer);
    }

    @DeleteMapping(path ={"/{id}"})
    public OfferEntity delete(@PathVariable("id") int id) {
        return offerService.delete(id);
    }

    @GetMapping
    public List<OfferEntity> findAll(){
        return offerService.findAll();
    }


}
