package com.example.demo.controller;


import java.net.URI;
import java.util.Map;
import java.util.Optional;

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

import com.example.demo.manager.TicketManager;
import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Employee;
import com.example.demo.model.Ticket;

@RestController
@RequestMapping(path="/tickets")
public class NewTicketController {

	@Autowired
	private TicketManager manager;

	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Object> addNewTicket(@RequestBody Ticket ticket) throws Exception {
		return new ResponseEntity<>(manager.postNewTicket(ticket), HttpStatus.CREATED);
	}
	
}
