package com.example.demo.manager;

import com.example.demo.model.Employee;

public interface EmployeeManager {

	public Employee findLogin(String email, String password);
	public Employee getAccount(int id);
	
}