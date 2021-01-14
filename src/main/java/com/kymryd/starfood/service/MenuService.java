package com.kymryd.starfood.service;

import com.kymryd.starfood.model.entities.MenuEntity;

import java.util.List;

public interface MenuService {
    MenuEntity create(MenuEntity menu);

    MenuEntity delete(int id);

    List<MenuEntity> findAll();

    MenuEntity findById(int id);

    MenuEntity update(MenuEntity menu);

}
