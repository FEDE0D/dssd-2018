package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.*;
import com.dssd.grupo8.model.Employee;
import com.dssd.grupo8.model.EmployeeType;
import com.dssd.grupo8.model.Product;
import com.dssd.grupo8.model.ProductType;
import com.dssd.grupo8.repository.EmployeeRepository;
import com.dssd.grupo8.repository.EmployeeTypeRepository;
import com.dssd.grupo8.repository.ProductRepository;
import com.dssd.grupo8.repository.ProductTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, ProductRepository, ProductDTO, ProductCreationDTO, ProductUpdateDTO> {

    private ProductTypeRepository typeRepository;

    @Autowired
    public ProductService(ProductRepository repository, ModelMapper modelMapper, ProductTypeRepository typeRepository) {
        super(repository, modelMapper);
        this.typeRepository = typeRepository;
    }

    @Override
    public ProductDTO createFromDTO(ProductCreationDTO createDTO) {
        Product product = new Product();

        product.setName(createDTO.getName());
        product.setCostprice(createDTO.getCostprice());
        product.setSaleprice(createDTO.getSaleprice());

        product.setType(new ProductType(createDTO.getType().getInitials(), createDTO.getType().getDescription()));
        this.typeRepository.save(product.getType());
        this.repository.save(product);

        return this.modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO updateFromDTO(Long id, ProductUpdateDTO updateDTO) {
        Product product = this.findById(id);

        product.setName(updateDTO.getName());
        product.setCostprice(updateDTO.getCostprice());
        product.setSaleprice(updateDTO.getSaleprice());

        if (updateDTO.getType() != null) {
            product.getType().setInitials(updateDTO.getType().getInitials());
            product.getType().setDescription(updateDTO.getType().getDescription());
            this.typeRepository.save(product.getType());
        }
        this.repository.save(product);

        return this.modelMapper.map(product, ProductDTO.class);
    }

}
