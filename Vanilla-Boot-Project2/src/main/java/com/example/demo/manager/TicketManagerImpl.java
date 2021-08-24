package com.example.demo.manager;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.EmployeeDao;
import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Employee;
import com.example.demo.model.Ticket;

@Service
public class TicketManagerImpl implements TicketManager {

	@Autowired
	private TicketDAO dao;
	
	@Autowired
	private EmployeeDao eDao;
	
	@Override
	public Optional<Ticket> postNewTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		
//		data being written to ticket is changed from 
//		what is confirmed to be sending on the front end
		
		
		try {
			System.out.println(ticket.getEmpId());
			int empid = ticket.getEmpId();
			
			Optional<Employee> e = eDao.findById(empid);
			if(!e.isPresent()) {
				System.out.println("not present");
			} else {
				ticket.setEmployee(e.get());
				Date d = new Date();
				ticket.setTime(d);
				dao.save(ticket);
			}	
		
		} catch(Exception j) {
			System.out.println(j);
		}
		
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
