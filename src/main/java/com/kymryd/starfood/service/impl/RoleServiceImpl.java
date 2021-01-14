package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.RoleRepository;
import com.kymryd.starfood.model.entities.RoleEntity;
import com.kymryd.starfood.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public RoleEntity create(RoleEntity role) {
        return repository.save(role);
    }

    @Override
    public RoleEntity delete(int id) {
        RoleEntity role = findById(id);
        if(role != null){
            repository.delete(role);
        }
        return role;
    }

    @Override
    public List<RoleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public RoleEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public RoleEntity update(RoleEntity role) {
        return repository.save(role);
    }
}
