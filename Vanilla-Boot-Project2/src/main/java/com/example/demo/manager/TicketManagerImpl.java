package com.example.demo.manager;

import java.util.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.manager.dao.EmployeeDao;
import com.example.demo.manager.dao.TicketDAO;
import com.example.demo.model.Employee;
import com.example.demo.model.Ticket;

@Service
public class TicketManagerImpl implements TicketManager {

	private static final Logger logger = LogManager.getLogger(TicketManagerImpl.class.getName());
	
	@Autowired
	private TicketDAO dao;
	
	@Autowired
	private EmployeeDao eDao;
	
	@Override
	public Optional<Ticket> postNewTicket(Ticket ticket) {
//		data being written to ticket is changed from 
//		what is confirmed to be sending on the front end
		
		try {
			int empid = ticket.getEmpId();
			logger.info("Accessing database");
			Optional<Employee> e = eDao.findById(empid);
			if(!e.isPresent()) {
				logger.info("User Not Present");
			} else {
				ticket.setEmployee(e.get());
				Date d = new Date();
				ticket.setTime(d);
				logger.info("Adding Ticket to Database");
				dao.save(ticket);
			}	
		
		} catch(Exception j) {
			logger.warn(j);
		}
		
		logger.info("Returning Added Ticket");
		return dao.findById(ticket.getId());
	}

}
