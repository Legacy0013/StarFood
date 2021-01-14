package com.kymryd.starfood.service.impl;

import com.kymryd.starfood.dao.StatusRepository;
import com.kymryd.starfood.model.entities.StatusEntity;
import com.kymryd.starfood.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository repository;

    @Override
    public StatusEntity create(StatusEntity status) {
        return repository.save(status);
    }

    @Override
    public StatusEntity delete(int id) {
        StatusEntity status = findById(id);
        if(status != null){
            repository.delete(status);
        }
        return status;
    }

    @Override
    public List<StatusEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public StatusEntity findById(int id) {
        return repository.findById(id);
    }

    @Override
    public StatusEntity update(StatusEntity status) {
        return repository.save(status);
    }
}
