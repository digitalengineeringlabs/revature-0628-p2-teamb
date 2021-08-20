package com.example.demo.controller;


import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.manager.LoginManager;
import com.example.demo.manager.TicketManager;
import com.example.demo.model.Employee;
import com.example.demo.model.Ticket;

@RestController
@RequestMapping(path="/tickets")
public class NewTicketController {

	@Autowired
	private TicketManager manager;
	
//	@GetMapping(produces="application/json")
//	public Ticket test() {
//		Employee e = new Employee();
//		e.setEmail("someemail@gmail.com");
//		e.setPassword("test");
//		
//		return e;
//	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Object> addTicket(@RequestBody Ticket ticket) throws Exception {
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/new")
				.buildAndExpand(1) // This variable may be wrong? should replace with db serial?
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
		
		
	}
	
}
