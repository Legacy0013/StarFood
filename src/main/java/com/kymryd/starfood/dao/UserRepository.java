package com.kymryd.starfood.dao;

import com.kymryd.starfood.model.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    void delete(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findById(int id);

    UserEntity save(UserEntity user);

    UserEntity findByUserEmail(String userEmail);
}

