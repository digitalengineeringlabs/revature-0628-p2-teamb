package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Ticket;
import com.example.demo.repo.TicketRepository;


@Service
public class TicketService {
	
	@Autowired 
	private TicketRepository repository;

	public List<Ticket>getTickets() {
		return repository.findAll();
	}
	

}
