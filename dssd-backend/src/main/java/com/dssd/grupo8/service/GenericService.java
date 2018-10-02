package com.dssd.grupo8.service;

import com.dssd.grupo8.repository.GenericRepository;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class GenericService<Model, Repository extends GenericRepository<Model>, ModelDTO, CreationDTO, UpdateDTO> {

    Repository repository;

    ModelMapper modelMapper;

    public GenericService(Repository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<Model> findAll() {
        return this.repository.findAll();
    }

    @Transactional
    public Model findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Transactional
    public abstract ModelDTO createFromDTO(CreationDTO creationDTO);

    @Transactional
    public abstract ModelDTO updateFromDTO(Long id, UpdateDTO updateDTO);

    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
