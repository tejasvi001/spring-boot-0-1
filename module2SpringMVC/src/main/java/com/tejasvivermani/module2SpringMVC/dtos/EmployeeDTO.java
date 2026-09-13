package com.tejasvivermani.module2SpringMVC.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private UUID id;

    private String employeeName;

    private Date dateOfJoining;

    private String email;

}
