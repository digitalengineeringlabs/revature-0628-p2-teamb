package com.example.demo.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Ticket;

@Service
public class TicketManagerImpl implements TicketManager {

	@Autowired
	private TicketDAO dao;
	
	@Override
	public Optional<Ticket> postNewTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		dao.save(ticket);
		return dao.findById(ticket.getId());
		
	}
	
	
//	@Autowired
//	private EmployeeDao dao;
//	
//	@Override
//	public Employee findLogin(String email, String password) {
//		Employee e = dao.findLogin(email);
//		if(e != null && e.getPassword().equals(password)) {
//			return e;
//		}
//		return null;
//	}

}
