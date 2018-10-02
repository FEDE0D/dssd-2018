package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.*;
import com.dssd.grupo8.model.Employee;
import com.dssd.grupo8.model.EmployeeType;
import com.dssd.grupo8.repository.EmployeeRepository;
import com.dssd.grupo8.repository.EmployeeTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends GenericService<Employee, EmployeeRepository, EmployeeDTO, EmployeeCreationDTO, EmployeeUpdateDTO> {

    private EmployeeTypeRepository employeeTypeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository repository, ModelMapper modelMapper, EmployeeTypeRepository employeeTypeRepository) {
        super(repository, modelMapper);
        this.employeeTypeRepository = employeeTypeRepository;
    }

    @Override
    public EmployeeDTO createFromDTO(EmployeeCreationDTO createDTO) {
        Employee employee = new Employee();
        EmployeeType type = new EmployeeType(createDTO.getType().getInitials(), createDTO.getType().getDescription());

        employee.setFirstname(createDTO.getEmail());
        employee.setSurname(createDTO.getSurname());
        employee.setPassword(createDTO.getPassword());
        employee.setEmail(createDTO.getEmail());

        employee.setType(type);
        this.employeeTypeRepository.save(type);
        this.repository.save(employee);

        return this.modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateFromDTO(Long id, EmployeeUpdateDTO updateDTO) {
        Employee employee = findById(id);

        employee.setFirstname(updateDTO.getEmail());
        employee.setSurname(updateDTO.getSurname());
        employee.setPassword(updateDTO.getPassword());

        if (updateDTO.getType() != null) {
            employee.getType().setInitials(updateDTO.getType().getInitials());
            employee.getType().setDescription(updateDTO.getType().getDescription());
            this.employeeTypeRepository.save(employee.getType());
        }

        this.repository.save(employee);

        return this.modelMapper.map(employee, EmployeeDTO.class);
    }

}
