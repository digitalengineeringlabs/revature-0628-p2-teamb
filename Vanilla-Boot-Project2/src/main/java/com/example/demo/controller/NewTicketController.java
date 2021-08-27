package com.example.demo.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.manager.TicketManager;
import com.example.demo.model.Ticket;

@RestController
@RequestMapping(path="/tickets")
public class NewTicketController {

	private static final Logger logger = LogManager.getLogger(NewTicketController.class.getName());
	
	@Autowired
	private TicketManager manager;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Object> addNewTicket(@RequestBody Ticket ticket) {
		logger.info("Recieved Add new Ticket Request");
		try {
			logger.info("Sending Successful Add new Ticket Response");
			return new ResponseEntity<>(manager.postNewTicket(ticket), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.warn("Failed to add new ticket");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
