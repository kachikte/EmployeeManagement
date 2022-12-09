package com.employee.management.serviceImpl;


import com.employee.management.dto.EmployeeDto;
import com.employee.management.model.Employee;
import com.employee.management.pojo.EmployeePojo;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeePojo addEmployee(EmployeeDto employeeDto) throws Exception {
        Employee employee = new Employee(employeeDto);


            return new EmployeePojo(employeeRepository.save(employee));

    }

    @Override
    public EmployeePojo getEmployee(long employeeId) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(Exception::new);
        return new EmployeePojo(employee);
    }

    @Override
    public EmployeePojo updateEmployee(long employeeId, EmployeeDto employeeDto) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(Exception::new);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setAddress(employeeDto.getAddress());
        employee.setLevel(employeeDto.getLevel());

        return new EmployeePojo(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeePojo> deleteEmployee(long employeeId) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(Exception::new);
        employeeRepository.deleteById(employeeId);
        return getEmployees();
    }

    @Override
    public List<EmployeePojo> getEmployees() {
        List<EmployeePojo> employeePojos = new ArrayList<>();
        for (Employee employee: employeeRepository.findAll()) {
            employeePojos.add(new EmployeePojo(employee));
        }

        return employeePojos;
    }
}
