package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.UserRepository;
import com.kymryd.starfood.model.entities.UserEntity;
import com.kymryd.starfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity create(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public UserEntity delete(int id) {
        UserEntity user = findById(id);
        if(user != null){
            repository.delete(user);
        }
        return user;
    }

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return repository.save(user);
    }
}
