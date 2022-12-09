package com.employee.management.service;

import com.employee.management.pojo.EmployeeImagePojo;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeImageService {
    EmployeeImagePojo addFile(long employeeId, MultipartFile multipartFile) throws Exception;
}
