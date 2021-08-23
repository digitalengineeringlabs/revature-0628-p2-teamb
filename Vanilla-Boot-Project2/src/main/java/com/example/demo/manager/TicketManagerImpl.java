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
		System.out.println(ticket.getEmpId());
		// TODO Auto-generated method stub
		int i = ticket.getEmpId();
		Optional<Employee> e = null;	
		try {
			e = eDao.findById(i);			
		} catch (Exception f) {
			System.out.println(f);
		}
		Date d = new Date();
		ticket.setTime(d);
		ticket.setEmployee(e.get());
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
