package com.employee.management.controller;

import com.employee.management.dto.EmployeeDto;
import com.employee.management.pojo.EmployeePojo;
import com.employee.management.service.EmployeeService;
import com.employee.management.response.EMResponseCode;
import com.employee.management.response.EMResponseEntity;
import com.employee.management.response.EMResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EMResponseEntity> addEmployees(@RequestBody EmployeeDto employeeDto) throws Exception {

        EmployeePojo employeePojo = employeeService.addEmployee(employeeDto);
        EMResponseEntity dmResponseEntity = new EMResponseEntity(EMResponseCode.SUCCESS, EMResponseMessage.SUCCESS_MESSAGE, employeePojo);
        return  ResponseEntity.ok(dmResponseEntity);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<EMResponseEntity> getEmployee(@PathVariable long employeeId) throws Exception {

        EmployeePojo employeePojo = employeeService.getEmployee(employeeId);
        EMResponseEntity dmResponseEntity = new EMResponseEntity(EMResponseCode.SUCCESS, EMResponseMessage.SUCCESS_MESSAGE, employeePojo);
        return  ResponseEntity.ok(dmResponseEntity);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<EMResponseEntity> updateEmployees(@PathVariable long employeeId, @RequestBody EmployeeDto employeeDto) throws Exception {

        EmployeePojo employeePojo = employeeService.updateEmployee(employeeId, employeeDto);
        EMResponseEntity dmResponseEntity = new EMResponseEntity(EMResponseCode.SUCCESS, EMResponseMessage.SUCCESS_MESSAGE, employeePojo);
        return  ResponseEntity.ok(dmResponseEntity);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<EMResponseEntity> deleteEmployee(@PathVariable long employeeId) throws Exception {

        List<EmployeePojo> employeePojos = employeeService.deleteEmployee(employeeId);
        EMResponseEntity dmResponseEntity = new EMResponseEntity(EMResponseCode.SUCCESS, EMResponseMessage.SUCCESS_MESSAGE, employeePojos);
        return  ResponseEntity.ok(dmResponseEntity);
    }

    @GetMapping("/get-employees")
    public ResponseEntity<EMResponseEntity> getEmployees(){
        List<EmployeePojo> employeePojoList = employeeService.getEmployees();
        EMResponseEntity dmResponseEntity = new EMResponseEntity(EMResponseCode.SUCCESS, EMResponseMessage.SUCCESS_MESSAGE, employeePojoList);
        return  ResponseEntity.ok(dmResponseEntity);
    }
}
