package com.example.demo.manager.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Integer>{
	
	@Query("select t from Ticket t where t.employee_id = :EmployeeID")
	public Ticket postNewTicket(@Param("EmployeeID") Ticket ticket);
	
}
