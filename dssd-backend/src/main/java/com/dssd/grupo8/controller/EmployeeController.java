package com.dssd.grupo8.controller;

import com.dssd.grupo8.dto.*;
import com.dssd.grupo8.model.Employee;
import com.dssd.grupo8.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends GenericController<Employee, EmployeeService, EmployeeDTO, EmployeeCreationDTO, EmployeeUpdateDTO> {

    @Override
    Class<EmployeeDTO> dtoClass() {
        return EmployeeDTO.class;
    }

    public EmployeeController(EmployeeService service, ModelMapper modelMapper) {
        super(service, modelMapper);
    }

}
