package com.dssd.grupo8.controller;

import com.dssd.grupo8.repository.GenericRepository;
import com.dssd.grupo8.service.GenericService;
import org.hibernate.sql.Update;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
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
public abstract class GenericController<Model, Service extends GenericService<Model, GenericRepository<Model>, CreationDTO, UpdateDTO>, ModelDTO, CreationDTO, UpdateDTO> {

    Service service;

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
            allDTO.add(modelMapper.map(m, new TypeToken<ModelDTO>() {}.getType()));
        }
        return ResponseEntity.ok(allDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> findById(
        @PathParam("id") Long id
    ) {
        Model model = service.findById(id);
        return ResponseEntity.ok(this.modelMapper.map(model, new TypeToken<ModelDTO>(){}.getType()));
    }

    @PostMapping
    public ResponseEntity<ModelDTO> create(
        @RequestBody CreationDTO creationDTO
    ) {
        Model model = service.createFromDTO(creationDTO);
        return ResponseEntity.ok(this.modelMapper.map(model, new TypeToken<ModelDTO>(){}.getType()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> update(
        @PathParam("id") Long id,
        @RequestBody UpdateDTO updateDTO
    ) {
        Model model = service.updateFromDTO(id, updateDTO);
        return ResponseEntity.ok(this.modelMapper.map(model, new TypeToken<ModelDTO>(){}.getType()));
    }


}
