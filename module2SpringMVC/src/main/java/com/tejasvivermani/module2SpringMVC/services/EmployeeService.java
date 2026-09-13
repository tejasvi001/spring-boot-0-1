package com.tejasvivermani.module2SpringMVC.services;

import com.tejasvivermani.module2SpringMVC.dtos.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface EmployeeService {
    public EmployeeDTO getEmployeeByID(UUID id);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO updateEmployee(UUID id, EmployeeDTO employeeDTO);

    public EmployeeDTO updateEmployee(UUID id, Map<String, Object> employeeToUpdate);

    public  EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    public Boolean deleteEmployee(UUID id);

}
