package com.employee.management.repository;

import com.employee.management.model.EmployeeImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeImageRepository extends CrudRepository<EmployeeImage, Long> {
}
