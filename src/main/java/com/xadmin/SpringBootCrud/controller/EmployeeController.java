package com.xadmin.SpringBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Employee;
import com.xadmin.SpringBootCrud.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id)
	{
		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value="/employees")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/employees/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody Employee employee)
	{
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PATCH, value="/employees/{id}")
	public ResponseEntity<String> patchEmployee(@PathVariable String id, @RequestBody Employee employee)
	{
		employeeService.patchEmployee(id, employee);
		return new ResponseEntity<>("Employee patched successfully", HttpStatus.OK);
	}
}