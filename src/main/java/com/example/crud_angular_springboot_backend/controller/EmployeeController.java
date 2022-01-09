package com.example.crud_angular_springboot_backend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_angular_springboot_backend.model.Employee;
import com.example.crud_angular_springboot_backend.service.EmployeeService;


@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	

	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	//create employee rest api
//	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee employee) {
		return service.create(employee);
	}
	
	//get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	//update employee rest api
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		return service.updateEmployee(id,employee);
	}
	
	//delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		return service.deleteEmployee(id);
	}
	
	

}
