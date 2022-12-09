package com.employee.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String level;
}
