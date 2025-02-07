package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entities.Employee;
import com.global.hr.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeservice;

	@Autowired
	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	@GetMapping("/list")
	public String listEmployees (Model model) {
		List <Employee> allEmployees = employeeservice.findAll();
//		for (Employee emp:allEmployees) {
//			System.out.println(emp.toString());
//		}
		model.addAttribute("employees", allEmployees);
		return "employees/list-employees";
	}
	
	@GetMapping ("showAddForm")
	public String showForm(Model model) {
		Employee newemp=new Employee();
		model.addAttribute("employee",newemp);
		
		return "employees/EmployeeForm";
		
	}
	@PostMapping ("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee) {
		employeeservice.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("showUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int id, Model model ) {
		Employee emp=employeeservice.findById(id);
		model.addAttribute("employee", emp);
		return "employees/EmployeeForm";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// delete the employee
		employeeservice.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/employees/list";

	}
	
	
	

}
