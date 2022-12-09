package com.employee.management.model;


import com.employee.management.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String level;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    @JsonManagedReference
    @Nullable
    private List<EmployeeImage> employeeImageList;


    public Employee(EmployeeDto employeeDto) {
        this.userName = employeeDto.getUserName();
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.age = employeeDto.getAge();
        this.address = employeeDto.getAddress();
        this.level = employeeDto.getLevel();
    }
}
