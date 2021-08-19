package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.manager.LoginManager;
import com.example.demo.model.Employee;

@RestController
@RequestMapping(path="/login")
public class LoginController {

	@Autowired
	private LoginManager lm;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<Object> getEmployeeLogin(@RequestBody Employee employee) {
		System.out.println(employee.getEmail());
		System.out.println(employee.getPassword());
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(1)
//				.toUri();
//		System.out.println(location);
//		ResponseEntity<Object> obj = ResponseEntity.created(location).build();
//		System.out.println(obj);
//		return ResponseEntity.created(location).build();
	}
	
}
