package driver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import driver.model.Ticket;
import driver.repo.TicketRepository;

@Service
public class TicketService {
	
	@Autowired 
	private TicketRepository repository;

	public List<Ticket>getTickets() {
		return repository.findAll();
	}
	

}
