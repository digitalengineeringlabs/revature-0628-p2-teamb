package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger logger = LogManager.getLogger(TicketController.class.getName());
	
	@Autowired
	private TicketService service;
	
	@GetMapping("/Alltickets")
	public List<Ticket> getTickets(){
		logger.info("Recieved Get All Tickets Request");
		return service.getTickets();
	}

	
}
