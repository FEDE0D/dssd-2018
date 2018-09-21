package com.dssd.grupo8.service;

import org.modelmapper.ModelMapper;

public class GenericService<T, R> {

    R repository;

    ModelMapper modelMapper;

    public GenericService(R repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

}
