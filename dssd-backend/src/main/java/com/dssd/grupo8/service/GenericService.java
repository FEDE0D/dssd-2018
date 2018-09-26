package com.dssd.grupo8.service;

import com.dssd.grupo8.repository.GenericRepository;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericService<T, R extends GenericRepository<T>> {

    R repository;

    ModelMapper modelMapper;

    public GenericService(R repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<T> findAll() {
        return this.repository.findAll();
    }

}
