package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ticket;
import com.example.demo.repository.Repository;
import com.example.demo.services.TicketService;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TicketController {

	private static final Logger logger = LogManager.getLogger(TicketController.class.getName());
	
	@Autowired
	private TicketService service;
	@Autowired
	Repository repository;
	
	@GetMapping("/Alltickets")
	public List<Ticket> getTickets(){
		logger.info("Recieved Get All Tickets Request");
		return service.getTickets();
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Ticket> updateTutorial(@PathVariable("id") Integer id, @RequestBody Ticket riembursement) {
		Optional<Ticket> tutorialData = repository.findById(id);

		if (tutorialData.isPresent()) {
			Ticket newobj = tutorialData.get();
			newobj.setAmount(riembursement.getAmount());
			newobj.setDescription(riembursement.getDescription());
			newobj.setType(riembursement.getType());
			newobj.setId(riembursement.getId());
			newobj.setStatus(riembursement.getStatus());
			newobj.setEmpId(riembursement.getEmpId());
			newobj.setTime(riembursement.getTime());
			return new ResponseEntity<>(repository.save(newobj), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
