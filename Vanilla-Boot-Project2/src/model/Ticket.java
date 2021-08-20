package model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ticket_id;

	@Column(name = "employee_id")
	private int employee_id;

	@Column(name = "type")
	private String type;

	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "status")
	private String status;

	public Ticket() {

	}

	public Ticket(long ticket_id, int employee_id, String type, String description, float amount,Date time,String status) {
		this.ticket_id= ticket_id;
		this.employee_id=employee_id;
		this.type=type;
		this.description=description;
		this.amount=amount;
		this.time=time;
		this.status=status;
	}

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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


	/*
	@Override
	public String toString() {
		return "ticket [ticket_id=" + ticket_id + ", employee_id=" + employee_id ]";
	}
*/
}
