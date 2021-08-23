package com.example.demo.manager;

import java.util.Optional;

import com.example.demo.model.Ticket;

public interface TicketManager {

	public Optional<Ticket> postNewTicket(Ticket ticket);
	
}
