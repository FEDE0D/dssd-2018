package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.EmployeeCreationDTO;
import com.dssd.grupo8.dto.EmployeeDTO;
import com.dssd.grupo8.dto.EmployeeTypeCreationDTO;
import com.dssd.grupo8.model.Employee;
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
public class EmployeeServiceTestCase {

    @Autowired
    @Getter
    private EmployeeService service;

    @Test
    public void basicTest() {
        EmployeeDTO employee = service.createFromDTO(new EmployeeCreationDTO("federico", "pacheco", "federico@gmail.com", new EmployeeTypeCreationDTO("INI", "some description")));
        Assert.assertNotNull(employee.getId());
        Assert.assertEquals("federico@gmail.com", employee.getEmail());

        Assert.assertEquals("INI", employee.getType().getInitials());

        List<Employee> employees = service.findAll();
        Assert.assertEquals(1, employees.size());
    }

}
