package com.tejasvivermani.module2SpringMVC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "t_employee")
public class EmployeeEntity {
    @Id
    private UUID id ;
    private String employeeName;
    private Date dateOfJoining;
    private String email;
}
