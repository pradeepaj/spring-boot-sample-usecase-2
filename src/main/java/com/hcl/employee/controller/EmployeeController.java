package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.dto.EmployeeDto;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployee(employeeDto);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeDto employeeDetail(@RequestParam ("id") long id) {
		return employeeService.getEmployee(id);
	}
	@DeleteMapping("employee/{id}")
	public String removeEmployee(@RequestParam("id") Long id) {
		return employeeService.removeEmployee(id);
	}
	

}
