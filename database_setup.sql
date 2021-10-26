-- DROP SCHEMA reimbursement;

CREATE SCHEMA reimbursement AUTHORIZATION postgres;

-- reimbursement.employee_id_seq definition

-- DROP SEQUENCE reimbursement.employee_id_seq;

CREATE SEQUENCE reimbursement.employee_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- reimbursement.ticket_id_seq definition

-- DROP SEQUENCE reimbursement.ticket_id_seq;

CREATE SEQUENCE reimbursement.ticket_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
	
	
	
	-- reimbursement.employee definition

-- Drop table

-- DROP TABLE reimbursement.employee;

CREATE TABLE reimbursement.employee (
	employee_id int4 NOT NULL DEFAULT nextval('reimbursement.employee_id_seq'::regclass),
	username varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	"role" varchar NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (employee_id)
);


-- reimbursement.ticket definition

-- Drop table

-- DROP TABLE reimbursement.ticket;

CREATE TABLE reimbursement.ticket (
	ticket_id int4 NOT NULL DEFAULT nextval('reimbursement.ticket_id_seq'::regclass),
	employee_id int4 NOT NULL,
	"type" varchar NOT NULL,
	description varchar NOT NULL,
	amount float4 NOT NULL,
	"time" timestamp NOT NULL,
	status varchar NOT NULL,
	empid int4 NULL,
	CONSTRAINT ticket_pk PRIMARY KEY (ticket_id),
	CONSTRAINT ticket_fk FOREIGN KEY (employee_id) REFERENCES reimbursement.employee(employee_id)
);


insert into reimbursement.employee (username, email, "password", "role", first_name, last_name) values ('alec-patterson', 'alec.patterson@revature.net', 'employee', 'alec', 'patterson');
insert into reimbursement.ticket (employee_id, "type", description, amount, "time", status) values ((select employee_id from reimbursement.employee where username = 'alec-patterson'), 'food', 'Pizza time', 5.00, now(), 'pending');

