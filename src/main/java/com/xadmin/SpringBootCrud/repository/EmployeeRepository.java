package com.xadmin.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.xadmin.SpringBootCrud.bean.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
	
}