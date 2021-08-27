package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Ticket;



@Service
public class TicketService {
	
	@Autowired 
	private TicketDAO repository;

	public List<Ticket>getTickets() {
		return repository.findAll();
	}


	

}
