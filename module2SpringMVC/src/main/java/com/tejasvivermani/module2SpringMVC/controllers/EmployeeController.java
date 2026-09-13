package com.tejasvivermani.module2SpringMVC.controllers;

import com.tejasvivermani.module2SpringMVC.dtos.EmployeeDTO;
import com.tejasvivermani.module2SpringMVC.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable UUID id){
        if(id == null){
            throw new RuntimeException("Invalid ID");
        }
        EmployeeDTO employee = employeeService.getEmployeeByID(id);
        if(employee == null){
            //Return 404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTOList);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employee =  employeeService.createEmployee(employeeDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employee);
    }

    @PutMapping("/id")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable UUID id){
        EmployeeDTO employee = employeeService.updateEmployee(id,employeeDTO);
        return ResponseEntity.ok(employee);
    }

    @PatchMapping("/id")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Map<String,Object> map, @PathVariable UUID id){
        EmployeeDTO employee =  employeeService.updateEmployee(id,map);
        if(employee == null){
            //Return 404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable UUID id){
        Boolean isDeleted = employeeService.deleteEmployee(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(true);
    }

}
