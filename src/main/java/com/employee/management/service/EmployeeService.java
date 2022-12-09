package com.employee.management.service;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.pojo.EmployeePojo;

import java.util.List;

public interface EmployeeService {

    EmployeePojo addEmployee(EmployeeDto employeeDto) throws Exception;

    EmployeePojo getEmployee(long employeeId) throws Exception;

    EmployeePojo updateEmployee(long employeeId, EmployeeDto employeeDto) throws Exception;

    List<EmployeePojo> deleteEmployee(long employeeId) throws Exception;

    List<EmployeePojo> getEmployees();
}
