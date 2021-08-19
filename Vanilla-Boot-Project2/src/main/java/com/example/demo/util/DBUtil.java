package com.example.demo.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtil {
	private static DBUtil _instance = null;
	private SessionFactory factory = null;
	
	private DBUtil() {
		this.factory = new Configuration().configure().buildSessionFactory();
	}
	
	public static DBUtil getInstance() {
		if(_instance == null) {
			_instance = new DBUtil();
		}
		return _instance;
	}
	
	public Session getSession() {
		return this.factory.openSession();
	}
}
