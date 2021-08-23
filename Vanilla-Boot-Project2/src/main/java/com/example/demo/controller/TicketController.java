package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ticket;
import com.example.demo.services.TicketService;

@RestController
@CrossOrigin
@SpringBootApplication

public class TicketController {

	@Autowired
	private TicketService service;
	
	@GetMapping("/tickets")
	public List<Ticket> getTickets(){
		return service.getTickets();
	}

	
}
