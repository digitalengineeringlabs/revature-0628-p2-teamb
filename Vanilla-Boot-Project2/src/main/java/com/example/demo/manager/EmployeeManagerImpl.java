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
		Employee employee = dao.findLogin(email);
		if(employee != null && employee.getPassword().equals(password)) {
			return employee;
		}
		return null;
	}

	@Override
	public Employee getAccount(int id) {
		Optional<Employee> employee = dao.findById(id);
		if(!employee.isPresent()) {
			return null;
		} else {
			return employee.get();
		}
		
	}
	
}
