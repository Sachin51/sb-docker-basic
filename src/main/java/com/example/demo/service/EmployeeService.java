package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.customexception.RecordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll(Sort.by(Sort.Direction.ASC, "empName"));
	}
	
	
	public Employee findByEmployeeId(Long empId) {
		return empRepo.findById(empId)
				.orElseThrow(() -> new RecordNotFoundException("Not found Employee ","with id ",empId.toString()));
	}
	
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee employee = empRepo.findById( Long.parseLong(emp.getEmpId()))
				.orElseThrow(() -> new RecordNotFoundException("Not found Employee ","with id ",(emp.getEmpId()).toString()));
		
		employee.setEmpName(emp.getEmpName());
		employee.setHomeTown(emp.getHomeTown());
		employee.setMartialStatus(emp.getMartialStatus());
		employee.setRatingOfCompany(emp.getRatingOfCompany());
		employee.setSex(emp.isSex());
		employee.setDob(emp.getDob());
		
		;
		return empRepo.save(employee);
	}
	
	public ResponseEntity<?> deleteEmployee(String empId){
		Employee employee = empRepo.findById( Long.parseLong(empId))
				.orElseThrow(() -> new RecordNotFoundException("Not found Employee ","with id ",""));
		empRepo.delete(employee);
		return ResponseEntity.ok().build();
	}
}
