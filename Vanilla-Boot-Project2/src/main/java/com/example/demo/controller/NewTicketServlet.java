package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.Ticket;
import com.example.demo.util.DBUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@WebServlet("/ticket/new")
public class NewTicketServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/user POST pinged");
		
		// instantiate new objects for use
		ObjectMapper om = new ObjectMapper();
		Ticket newTicket = null;
		Session session = DBUtil.getInstance().getSession();
		// attempt to parse data from req.body
		try {
			newTicket = om.readValue(getJSONData(req), Ticket.class);
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		// make insert into query
		
		// write response		
		
		
		
	}
	
	
	public void postTicket(Ticket newTicket) {
		
	}
	
	
	public static String getJSONData(HttpServletRequest req) throws Exception {
		StringBuffer jsonStrBuffer = new StringBuffer();
		String line = null;

		BufferedReader reader = req.getReader();
		while ((line = reader.readLine()) != null)
			jsonStrBuffer.append(line);

		return jsonStrBuffer.toString();
	}
	
	

}
