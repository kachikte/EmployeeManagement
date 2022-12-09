package com.employee.management.repository;


import com.employee.management.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e.userName FROM Employee e WHERE e.userName = ?1")
    String findEmployeeByUserName(String username);
}
