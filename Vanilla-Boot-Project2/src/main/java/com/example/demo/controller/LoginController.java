package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.manager.EmployeeManager;
import com.example.demo.model.Employee;

@RestController
@RequestMapping(path="/login")
public class LoginController {

	@Autowired
	private EmployeeManager manager;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Object> getEmployeeLogin(@RequestBody Employee employee) {
		Employee employ = manager.findLogin(employee.getEmail(), employee.getPassword());
		if(employ != null)
			return new ResponseEntity<>("{\"id\":" + employ.getId() + ", \"role\": \"" + employ.getRole() + "\" }", HttpStatus.CREATED);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
}
