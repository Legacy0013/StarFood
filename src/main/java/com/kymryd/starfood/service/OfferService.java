package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.OfferEntity;

import java.util.List;

public interface OfferService {
    OfferEntity create(OfferEntity offer);

    OfferEntity delete(int id);

    List<OfferEntity> findAll();

    OfferEntity findById(int id);

    OfferEntity update(OfferEntity offer);

}
