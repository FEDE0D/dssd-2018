package com.dssd.grupo8.controller;

import com.dssd.grupo8.service.GenericService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericController<M, S extends GenericService> {

    S service;

    ModelMapper modelMapper;

    @Autowired
    public GenericController(S service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }


}
