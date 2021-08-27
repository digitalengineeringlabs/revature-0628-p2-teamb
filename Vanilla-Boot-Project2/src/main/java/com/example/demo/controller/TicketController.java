package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

	@Autowired
	private TicketService service;
	@Autowired
	Repository repository;
	
	@GetMapping("/Alltickets")
	public List<Ticket> getTickets(){
		return service.getTickets();
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Ticket> updateTutorial(@PathVariable("id") Integer id, @RequestBody Ticket riembursement) {
		Optional<Ticket> tutorialData = repository.findById(id);

		if (tutorialData.isPresent()) {
			Ticket _tutorial = tutorialData.get();
			_tutorial.setAmount(riembursement.getAmount());
			_tutorial.setDescription(riembursement.getDescription());
			_tutorial.setType(riembursement.getType());
			_tutorial.setId(riembursement.getId());
			_tutorial.setStatus(riembursement.getStatus());
			_tutorial.setEmpId(riembursement.getEmpId());
			_tutorial.setTime(riembursement.getTime());
			return new ResponseEntity<>(repository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
