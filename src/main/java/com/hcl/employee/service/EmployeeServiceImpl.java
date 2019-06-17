package com.hcl.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.dto.EmployeeDto;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public String addEmployee(EmployeeDto employeeDto) {
		
		if(employeeDto!=null) {
			Employee employee=new Employee();
			employee.setName(employeeDto.getName());
			employee.setDepartment(employeeDto.getDepartment());
			employee.setSalary(employeeDto.getSalary());
			employeeRepository.save(employee) ;
			return "Employee created successfully";
		}
		else
		{
			return "Invalid credentials";
		}
		
	}


	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employee=employeeRepository.findAll();
		return employee ;
	}


	@Override
	public EmployeeDto getEmployee(long id) {
		
		Employee employee=employeeRepository.findById(id).get();
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setName(employee.getName());
		employeeDto.setId(employee.getId());
		employeeDto.setDepartment(employee.getDepartment());
		employeeDto.setSalary(employee.getSalary());
		return employeeDto;
	}


	@Override
	public String removeEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee deleted successfully";
	}
	
	

}
