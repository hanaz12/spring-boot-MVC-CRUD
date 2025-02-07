package com.global.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.Repository.EmployeeRepository;
import com.global.hr.entities.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	

	private EmployeeRepository employeerepository;
	
	public EmployeeService(EmployeeRepository employeerepository) {
		super();
		this.employeerepository = employeerepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeerepository.findAll();
	}

	@Override
	public void save(Employee emp) {
		 employeerepository.save(emp);
		
	}

	

	@Override
	public void deleteById(int id) {
		employeerepository.deleteById(id);
		
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result=employeerepository.findById(id);
        Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return theEmployee;
		
	}
	
	

}
