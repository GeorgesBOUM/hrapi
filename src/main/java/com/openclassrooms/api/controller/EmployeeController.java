package com.openclassrooms.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@PostMapping("/employee")
	public Employee createEmployee(Employee e) {
		return es.saveEmployee(e);
	}
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployee() {
		return es.getEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") Long id) {
		Optional<Employee> e = es.getEmployee(id);
		if (e.isPresent()) {
			return e;
		} else {
			return Optional.empty();
		}
	}
	
	@PutMapping("/employee/{id}/")
	public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee e) {
		Optional<Employee> possiblyUpdate = es.getEmployee(id);
		if (possiblyUpdate.isPresent()) {
			Employee toUpdate = possiblyUpdate.get();
			toUpdate.setName(e.getName());
			toUpdate.setFirstName(e.getFirstName());
			toUpdate.setMail(e.getMail());
			toUpdate.setPassword(e.getPassword());
			return es.saveEmployee(toUpdate);
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		es.deleteEmployee(id);
	}
	
}
