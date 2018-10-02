package com.dssd.grupo8.controller;

import com.dssd.grupo8.dto.*;
import com.dssd.grupo8.model.Product;
import com.dssd.grupo8.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController extends GenericController<Product, ProductService, ProductDTO, ProductCreationDTO, ProductUpdateDTO> {

    @Override
    Class<ProductDTO> dtoClass() {
        return ProductDTO.class;
    }

    public ProductController(ProductService service, ModelMapper modelMapper) {
        super(service, modelMapper);
    }

}
