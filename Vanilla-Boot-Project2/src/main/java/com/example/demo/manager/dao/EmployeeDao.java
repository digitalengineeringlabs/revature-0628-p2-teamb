package com.example.demo.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e where e.email = :Email")
	public Employee findLogin(@Param("Email") String email);
	
}
