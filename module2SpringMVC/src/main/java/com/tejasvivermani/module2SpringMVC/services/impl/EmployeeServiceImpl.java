package com.tejasvivermani.module2SpringMVC.services.impl;

import com.tejasvivermani.module2SpringMVC.dtos.EmployeeDTO;
import com.tejasvivermani.module2SpringMVC.entities.EmployeeEntity;
import com.tejasvivermani.module2SpringMVC.repositories.EmployeeRepository;
import com.tejasvivermani.module2SpringMVC.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeRepository employeeRepository;
    public final ModelMapper modelMapper;
    @Override
    public EmployeeDTO getEmployeeByID(UUID id) {
        // Check if employee exists
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO) {
        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            return null;
        }
        EmployeeEntity employee = modelMapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(UUID id, Map<String,Object> updates) {
        boolean exists = isExistsById(id);

        if (!exists) {
            return null;
        }

        EmployeeEntity employee = employeeRepository.findById(id).get();

        updates.forEach((field, value) -> {
            Field f = ReflectionUtils.findField(EmployeeEntity.class, field);

            if (f == null) {
                throw new IllegalArgumentException("Field not found: " + field);
            }

            f.setAccessible(true);
            ReflectionUtils.setField(f, employee, value);
        });

        return modelMapper.map(
                employeeRepository.save(employee),
                EmployeeDTO.class
        );
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employee = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public Boolean deleteEmployee(UUID id) {
        boolean exists = isExistsById(id);
        if(!exists){
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

    public boolean isExistsById(UUID id){
        return employeeRepository.existsById(id);
    }
}
