package com.global.hr.service;

import java.util.List;
import com.global.hr.entities.Employee;

public interface EmployeeServiceInterface {
	
	List<Employee> findAll();
	
	void save(Employee emp);
	void deleteById(int id);
	
	Employee findById(int id);
	
	

}
