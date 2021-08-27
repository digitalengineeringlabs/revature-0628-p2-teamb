package com.example.demo.manager;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

	private static final Logger logger = LogManager.getLogger(EmployeeManagerImpl.class.getName());
	
	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee findLogin(String email, String password) {
		logger.info("Accessing database");
		Employee employee = dao.findLogin(email);
		System.out.println(employee);
		if(employee != null && employee.getPassword().equals(password)) {
			logger.info("Returning employee information");
			return employee;
		}
		return null;
	}

	@Override
	public Employee getAccount(int id) {
		logger.info("Accessing database");
		Optional<Employee> employee = dao.findById(id);
		if(!employee.isPresent()) {
			return null;
		} else {
			logger.info("Returning employee information");
			return employee.get();
		}
		
	}
	
}
