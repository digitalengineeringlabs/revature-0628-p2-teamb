package com.example.demo.manager;

import com.example.demo.model.Employee;

public interface EmployeeManager {

	public Employee findLogin(String username, String password);
	public Employee getAccount(int id);
	
}