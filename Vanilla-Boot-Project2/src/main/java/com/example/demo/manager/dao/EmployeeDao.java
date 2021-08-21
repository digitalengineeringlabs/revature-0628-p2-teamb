package com.example.demo.manager.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
