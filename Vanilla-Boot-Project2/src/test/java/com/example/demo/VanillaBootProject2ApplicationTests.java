package com.example.demo;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.manager.EmployeeManager;
import com.example.demo.manager.TicketManager;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class VanillaBootProject2ApplicationTests {

	@Autowired
	private EmployeeManager emanager;
	
	@Autowired
	private TicketManager tmanager;
	
	@Test
	void login() {
		Employee employee = emanager.findLogin("alec.patterson@revature.net", "test");
		assertEquals("alec", employee.getFirstname());
		assertEquals(1, employee.getId());
	}

	@Test
	void getAccount() {
		Employee employee = emanager.getAccount(1);
		assertEquals("patterson", employee.getLastname());
		assertEquals("employee", employee.getRole());
	}
	
	
	@Test
	void TestLoginWeb() {
		try {
			RestTemplate rest = new RestTemplate();
			String resourceUrl = "http://localhost:8080/login";
			Map<String, Object> arguments = new HashMap<>();
			arguments.put("email", "alec.patterson@revature.net");
			arguments.put("password", "test");				
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(arguments, headers);
			ResponseEntity<String> result = rest.exchange(resourceUrl, HttpMethod.POST, entity , String.class);
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(result.getBody(), new TypeReference<Map<String,Object>>(){});
			assertEquals(map.get("role"), "employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void TestGetRequestsWeb() {
		try {
			RestTemplate rest = new RestTemplate();
			String resourceUrl = "http://localhost:8080/getmytickets";
			Map<String, Object> arguments = new HashMap<>();
			arguments.put("id", 1);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(arguments, headers);
			ResponseEntity<List> result = rest.exchange(resourceUrl, HttpMethod.POST, entity, List.class);
			assertNotEquals(result.getBody(), null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void TestGetAllRequests() {
		try {
			RestTemplate rest = new RestTemplate();
			String resourceUrl = "http://localhost:8080/Alltickets";
			ResponseEntity<List> result = rest.getForEntity(resourceUrl, List.class);
			assertNotEquals(result.getBody(), null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}






