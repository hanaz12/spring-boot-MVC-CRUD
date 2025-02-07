package com.global.hr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.hr.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
