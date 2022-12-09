package com.employee.management.pojo;

import com.employee.management.model.Employee;
import com.employee.management.model.EmployeeImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePojo {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String level;

    private List<EmployeeImagePojo> employeeImagePojoList = new ArrayList<>();

    public EmployeePojo(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.age = employee.getAge();
        this.address = employee.getAddress();
        this.level = employee.getLevel();

        if (employee.getEmployeeImageList() != null) {
            for (EmployeeImage employeeImage: employee.getEmployeeImageList()) {
                EmployeeImagePojo employeeImagePojo = new EmployeeImagePojo(employeeImage);
                employeeImagePojoList.add(employeeImagePojo);
            }
        }
    }
}
