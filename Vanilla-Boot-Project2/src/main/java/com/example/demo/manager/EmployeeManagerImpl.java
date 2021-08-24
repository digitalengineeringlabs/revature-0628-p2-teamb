package com.example.demo.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

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

	@Override
	public Employee getAccount(int id) {
		Optional<Employee> e = dao.findById(id);
		if(!e.isPresent()) {
			return null;
		} else {
			return e.get();
		}
		
	}
	
}
