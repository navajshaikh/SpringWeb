package com.advance.service1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.advance.model1.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
