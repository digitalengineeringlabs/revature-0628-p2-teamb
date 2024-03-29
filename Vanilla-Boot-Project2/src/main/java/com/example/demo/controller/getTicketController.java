package com.example.demo.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.manager.EmployeeManager;
import com.example.demo.model.Employee;

@RestController
@RequestMapping(path="/getmytickets")
public class getTicketController {
	
	private static final Logger logger = LogManager.getLogger(getTicketController.class.getName());
	
	@Autowired
	EmployeeManager manager;
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Object> getMyTickets(@RequestBody Map<String, Object> map) {
		logger.info("Recieved MyTickets Post Request");
		Employee employee = manager.getAccount((int)map.get("id"));
		if(employee != null) {
			logger.info("Sending Successful MyTickets Response");
			return new ResponseEntity<>(employee.getTickets(), HttpStatus.CREATED);
		}
		logger.info("Sending Unsuccessful MyTickets Response");
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
}
