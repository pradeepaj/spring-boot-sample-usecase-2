package com.hcl.employee.service;

import java.util.List;

import com.hcl.employee.dto.EmployeeDto;
import com.hcl.employee.entity.Employee;

public interface EmployeeService {

	String addEmployee(EmployeeDto employeeDto);

	List<Employee> getAllEmployee();

	EmployeeDto getEmployee(long id);

	String removeEmployee(Long id);

}
