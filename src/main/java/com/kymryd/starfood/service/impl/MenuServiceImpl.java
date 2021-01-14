package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.MenuRepository;
import com.kymryd.starfood.model.entities.MenuEntity;
import com.kymryd.starfood.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public MenuEntity create(MenuEntity menu) {
        return repository.save(menu);
    }

    @Override
    public MenuEntity delete(int id) {
        MenuEntity menu = findById(id);
        if(menu != null){
            repository.delete(menu);
        }
        return menu;
    }

    @Override
    public List<MenuEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public MenuEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public MenuEntity update(MenuEntity menu) {
        return repository.save(menu);
    }
}
