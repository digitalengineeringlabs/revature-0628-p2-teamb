package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.manager.LoginManager;
import com.example.demo.model.Employee;

@RestController
@RequestMapping(path="/login")
public class LoginController {

	@Autowired
	private LoginManager manager;
	
	@GetMapping(produces="application/json")
	public Employee test() {
		Employee e = new Employee();
		e.setEmail("someemail@gmail.com");
		e.setPassword("test");
		
		return e;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Object> getEmployeeLogin(@RequestBody Employee employee) {
		System.out.println(employee.getEmail());
		System.out.println(employee.getPassword());
		return new ResponseEntity<>(manager.findLogin(employee.getEmail(), employee.getPassword()), HttpStatus.CREATED);
		
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
