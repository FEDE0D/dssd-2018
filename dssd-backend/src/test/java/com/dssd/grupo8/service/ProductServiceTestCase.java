package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.*;
import com.dssd.grupo8.model.Employee;
import com.dssd.grupo8.model.Product;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class ProductServiceTestCase {

    @Autowired
    @Getter
    private ProductService service;

    @Test
    public void basicTest() {
        ProductDTO product = service.createFromDTO(new ProductCreationDTO("jabon", 10L, 12L, new ProductTypeCreationDTO("INI", "some description")));
        Assert.assertNotNull(product.getId());
        Assert.assertEquals("jabon", product.getName());

        Assert.assertEquals("INI", product.getType().getInitials());

        List<Product> products = service.findAll();
        Assert.assertEquals(1, products.size());
    }

}
