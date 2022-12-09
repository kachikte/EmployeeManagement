package com.employee.management.serviceImpl;


import com.employee.management.exception.EMException;
import com.employee.management.model.Employee;
import com.employee.management.model.EmployeeImage;
import com.employee.management.pojo.EmployeeImagePojo;
import com.employee.management.repository.EmployeeImageRepository;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeImageServiceImpl implements EmployeeImageService {


    @Autowired
    EmployeeImageRepository employeeImageRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeImagePojo addFile(long employeeId, MultipartFile multipartFile) throws Exception {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(Exception::new);

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        if (fileName.contains("..")) {
            throw new EMException("Invalid file name");
        } else {
            long fileSize = multipartFile.getSize();
            String fileType = multipartFile.getContentType();
            byte[] data = multipartFile.getBytes();

            EmployeeImage employeeImage = new EmployeeImage(fileName, fileType, fileSize, data, employee);

            return new EmployeeImagePojo(employeeImageRepository.save(employeeImage));
        }
    }
}
