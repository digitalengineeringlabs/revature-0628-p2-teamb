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
//@CrossOrigin(origins = "http://localhost:4200"
@SpringBootApplication

public class TicketController {

	@Autowired
	private TicketService service;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/Alltickets")
	public List<Ticket> getTickets(){
		return service.getTickets();
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/home")
	public List<Ticket> getEmpTickets() {
		List<Ticket> allTickets = service.getTickets();
		List<Ticket> empTickets = null;
		for(int counter = 0; counter < allTickets.size(); counter++) {
			Ticket tic = allTickets.get(counter);
			if()
		}
		
		
		
		return empTickets;
	}
	
}
