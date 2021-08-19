package com.example.demo.manager;

import com.example.demo.model.Employee;

public interface LoginManager {

	public Employee findLogin(String username, String password);
	
}
