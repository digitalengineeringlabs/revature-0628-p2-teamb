package driver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//List<Ticket> findByEmpId(int employee_id);
//List<Ticket> findByTicketId(long ticket_id);
import driver.model.Ticket;
import driver.services.TicketService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@CrossOrigin
@SpringBootApplication
//@RequestMapping("/api")
public class Controller {

	@Autowired
	private TicketService service;
	
	@GetMapping("/tickets")
	public List<Ticket> getTickets(){
		return service.getTickets();
	}

	/*
	@GetMapping("/tickets")
	public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam(required = false) int employee_id) {
		try {
			List<Ticket> riembursements = new ArrayList<Ticket>();

			if (employee_id == 0)
				ticketDao.findAll().forEach(riembursements::add);
	//		else
	//			ticketDao.findByEmpId(employee_id).forEach(riembursements::add);

			if (riembursements.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(riembursements, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> getTicketsById(@PathVariable("id") long ticket_id) {
		Optional<Ticket> Data = ticketDao.findById((int) ticket_id);

		if (Data.isPresent()) {
			return new ResponseEntity<>(Data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tickets")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket riembursement) {
		try {
			Ticket reimb = ticketDao
					.save(new Ticket());
			return new ResponseEntity<>(reimb, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") long id, @RequestBody Ticket riembursement) {
		Optional<Ticket> tutorialData = ticketDao.findById((int) id);

		if (tutorialData.isPresent()) {
			Ticket riemb = tutorialData.get();
			riemb.setType(riembursement.getType());
			riemb.setDescription(riembursement.getDescription());
			riemb.setStatus(riembursement.getStatus());
			return new ResponseEntity<>(ticketDao.save(riemb), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") long ticket_id) {
		try {
			ticketDao.deleteById((int) ticket_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tickets")
	public ResponseEntity<HttpStatus> deleteAllTickets() {
		try {
			ticketDao.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
/*
	@GetMapping("/tickets/manager")
	public ResponseEntity<List<Ticket>> findByEmpId() {
		try {
			List<Ticket> riembursements = ticketDao.findByEmpId(1);

			if (riembursements.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(riembursements, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
*/
}
