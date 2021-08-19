package com.example.demo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.manager.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Repository
public class LoginManagerImpl implements LoginManager {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee findLogin(String username, String password) {
		
		return null;
	}

}
