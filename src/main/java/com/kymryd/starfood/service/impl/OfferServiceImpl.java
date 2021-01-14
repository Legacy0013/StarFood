package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.OfferRepository;
import com.kymryd.starfood.model.entities.OfferEntity;
import com.kymryd.starfood.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository repository;

    @Override
    public OfferEntity create(OfferEntity offer) {
        return repository.save(offer);
    }

    @Override
    public OfferEntity delete(int id) {
        OfferEntity offer = findById(id);
        if(offer != null){
            repository.delete(offer);
        }
        return offer;
    }

    @Override
    public List<OfferEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public OfferEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public OfferEntity update(OfferEntity offer) {
        return repository.save(offer);
    }
}
