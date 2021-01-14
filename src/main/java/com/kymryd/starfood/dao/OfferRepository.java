package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.OfferEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OfferRepository extends Repository<OfferEntity, Integer> {

    void delete(OfferEntity offer);

    List<OfferEntity> findAll();

    OfferEntity findById(int id);

    OfferEntity save(OfferEntity offer);
}
