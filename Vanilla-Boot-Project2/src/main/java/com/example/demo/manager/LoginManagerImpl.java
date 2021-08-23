package com.example.demo.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class LoginManagerImpl implements LoginManager {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee findLogin(String email, String password) {
		Employee e = dao.findLogin(email);
		if(e != null && e.getPassword().equals(password)) {
			return e;
		}
		return null;
	}

}
