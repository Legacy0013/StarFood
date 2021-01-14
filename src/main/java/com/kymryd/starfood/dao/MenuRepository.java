package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.MenuEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MenuRepository extends Repository<MenuEntity, Integer> {

    void delete(MenuEntity menu);

    List<MenuEntity> findAll();

    MenuEntity findById(int id);

    MenuEntity save(MenuEntity menu);
}
