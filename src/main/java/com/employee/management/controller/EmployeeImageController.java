package com.employee.management.controller;


import com.employee.management.pojo.EmployeeImagePojo;
import com.employee.management.service.EmployeeImageService;
import com.employee.management.response.EMResponseCode;
import com.employee.management.response.EMResponseEntity;
import com.employee.management.response.EMResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/file")
public class EmployeeImageController {

    @Autowired
    EmployeeImageService employeeImageService;

    @PostMapping("/addFile/{employeeId}")
    public ResponseEntity<EMResponseEntity> addFile(@PathVariable long employeeId, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest httpServletRequest) throws Exception {
        EmployeeImagePojo employeeImagePojo = employeeImageService.addFile(employeeId, multipartFile);
        EMResponseEntity emResponseEntity = new EMResponseEntity(EMResponseCode.SUCCESS, EMResponseMessage.SUCCESS_MESSAGE, employeeImagePojo);
        return ResponseEntity.ok(emResponseEntity);
    }
}
