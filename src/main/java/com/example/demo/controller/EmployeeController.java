package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;



@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@PostMapping(value = "/addEmployee",consumes = "application/json")
	public Employee addEmployee(@Valid @RequestBody Employee emp) {
		System.out.println("In service add employee method");
		return empService.addEmployee(emp);
	}
	
	@GetMapping(value = "/getEmployee/{empId}", produces = "application/json")
	public Employee getEmployee(@PathVariable long empId) {
		return empService.findByEmployeeId(empId);
	}
	
	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@PutMapping(value = "/updateEmployee", consumes = "application/json", produces = "application/json")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}
	
	@DeleteMapping(value = "/deleteEmployee/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String empId){
		return empService.deleteEmployee(empId);
	}
}
