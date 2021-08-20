package com.example.demo.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Ticket;

public class TicketManagerImpl implements TicketManager {

	@Autowired
	private TicketDAO dao;
	
	@Override
	public Ticket postNewTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
		Ticket t = dao.postNewTicket(ticket);
		if(t != null) {
			return t;
		}
		return null;
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
