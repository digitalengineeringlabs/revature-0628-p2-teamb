package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name="id_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
	@Column(name="ticket_id")
	private int id;
	
	@Column
	private String type;
	
	@Column
	private String description;
	
	@Column
	private float amount;
	
	@Column
	private Date time;
	
	@Column
	private String status;
	
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;
	
	
	public Ticket() {}
	
	public Ticket(String type, String description, float amount, Date time, String status) {
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
