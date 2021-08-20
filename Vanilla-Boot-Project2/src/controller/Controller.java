package driver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	driver.repository.Repository repository;

	@GetMapping("/tickets")
	public ResponseEntity<List<Ticket>> getAllTickets(@RequestParam(required = false) int employee_id) {
		try {
			List<Ticket> riembursements = new ArrayList<Ticket>();

			if (employee_id == 0)
				repository.findAll().forEach(riembursements::add);
			else
				repository.findByEmpId(employee_id).forEach(riembursements::add);

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
		Optional<Ticket> Data = repository.findById(ticket_id);

		if (Data.isPresent()) {
			return new ResponseEntity<>(Data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tickets")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket riembursement) {
		try {
			Ticket reimb = repository
					.save(new Ticket());
			return new ResponseEntity<>(reimb, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") long id, @RequestBody Ticket riembursement) {
		Optional<Ticket> tutorialData = repository.findById(id);

		if (tutorialData.isPresent()) {
			Ticket riemb = tutorialData.get();
			riemb.setType(riembursement.getType());
			riemb.setDescription(riembursement.getDescription());
			riemb.setStatus(riembursement.getStatus());
			return new ResponseEntity<>(repository.save(riemb), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") long ticket_id) {
		try {
			repository.deleteById(ticket_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tickets")
	public ResponseEntity<HttpStatus> deleteAllTickets() {
		try {
			repository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/tickets/manager")
	public ResponseEntity<List<Ticket>> findByEmpId() {
		try {
			List<Ticket> riembursements = repository.findByEmpId(1);

			if (riembursements.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(riembursements, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
