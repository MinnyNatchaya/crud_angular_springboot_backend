package com.example.crud_angular_springboot_backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.crud_angular_springboot_backend.exception.ResourceNotFoundException;
import com.example.crud_angular_springboot_backend.model.Employee;
import com.example.crud_angular_springboot_backend.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	//create employee rest api
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public ResponseEntity<Employee> getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id : " + id ));
		return ResponseEntity.ok(employee);
	}
	
	public ResponseEntity<Employee> updateEmployee(Long id,Employee employeeDetail){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id : " + id ));
		
		employee.setFirstName(employeeDetail.getFirstName());
		employee.setLastName(employeeDetail.getLastName());
		employee.setEmailId(employeeDetail.getEmailId());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id : " + id ));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}


	


	
}
