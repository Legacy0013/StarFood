package com.kymryd.starfood.service;


import com.kymryd.starfood.model.entities.UserEntity;

import java.util.List;


public interface UserService {
    UserEntity create(UserEntity user);

    UserEntity delete(int id);

    List<UserEntity> findAll();

    UserEntity findById(int id);

    UserEntity update(UserEntity user);

}
