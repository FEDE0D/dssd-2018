package com.dssd.grupo8.controller;

import com.dssd.grupo8.repository.GenericRepository;
import com.dssd.grupo8.service.GenericService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic controller
 * @param <Model>
 * @param <Service>
 * @param <ModelDTO>
 * @param <CreationDTO>
 * @param <UpdateDTO>
 */
public abstract class GenericController<Model, Service extends GenericService<Model, ? extends GenericRepository<Model>, ModelDTO, CreationDTO, UpdateDTO>, ModelDTO, CreationDTO, UpdateDTO> {

    Service service;

    abstract Class<ModelDTO> dtoClass();

    ModelMapper modelMapper;

    @Autowired
    public GenericController(Service service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ModelDTO>> findAll() {
        List<Model> all = this.service.findAll();
        List<ModelDTO> allDTO = new ArrayList<>();
        for (Model m : all) {
            allDTO.add(modelMapper.map(m, dtoClass()));
        }
        return ResponseEntity.ok(allDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> findById(
        @PathVariable("id") Long id
    ) {
        Model model = service.findById(id);
        return ResponseEntity.ok(this.modelMapper.map(model, dtoClass()));
    }

    @PostMapping
    public ResponseEntity<ModelDTO> create(
        @RequestBody CreationDTO creationDTO
    ) {
        return ResponseEntity.ok(this.modelMapper.map(service.createFromDTO(creationDTO), dtoClass()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> update(
        @PathVariable("id") Long id,
        @RequestBody UpdateDTO updateDTO
    ) {
        return ResponseEntity.ok(this.modelMapper.map(service.updateFromDTO(id, updateDTO), dtoClass()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelDTO> delete(
            @PathVariable("id") Long id
    ) {
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
