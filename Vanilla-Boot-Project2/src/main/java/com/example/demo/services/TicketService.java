package com.example.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Ticket;



@Service
public class TicketService {
	
	private static final Logger logger = LogManager.getLogger(TicketService.class.getName());
	
	@Autowired 
	private TicketDAO repository;

	public List<Ticket>getTickets() {
		logger.info("Accessing database");
		logger.info("Returning All Tickets");
		return repository.findAll();
	}
	

}
