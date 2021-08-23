package com.example.demo.manager.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Ticket;



public interface TicketDAO extends JpaRepository<Ticket, Integer>{
	
	
	
}
