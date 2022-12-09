package com.employee.management.pojo;

import com.employee.management.model.EmployeeImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeImagePojo {
    private String fileNme;
    private String fileType;
    private long fileSize;
    private byte[] data;

    public EmployeeImagePojo(EmployeeImage employeeImage) {
        this.fileNme = employeeImage.getFileName();
        this.fileType = employeeImage.getFileType();
        this.fileSize = employeeImage.getFileSize();
        this.data = employeeImage.getData();
    }
}
