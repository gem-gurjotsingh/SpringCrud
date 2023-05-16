package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Employee;
import com.xadmin.SpringBootCrud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepo;

	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		employeeRepo.findAll().forEach(employees::add);
		return employees;
	}
	
	public Employee getEmployeeById(String id) {
	    Optional<Employee> optionalEmployee = employeeRepo.findById(id);
	    return optionalEmployee.orElse(null);
	}


	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	public void updateEmployee(String id, Employee employee) {
		employeeRepo.save(employee);
	}

	public void deleteEmployee(String id) {
		employeeRepo.deleteById(id);
	}

	public void patchEmployee(String id, Employee employee) {
		Optional<Employee> existingEmployee = employeeRepo.findById(id);
		if (existingEmployee.isPresent()) {
			Employee e = existingEmployee.get();
			e.setName(employee.getName() != null ? employee.getName() : e.getName());
			e.setLocation(employee.getLocation() != null ? employee.getLocation() : e.getLocation());
			e.setTeam(employee.getTeam() != null ? employee.getTeam() : e.getTeam());
			employeeRepo.save(e);
		}
	}
}
