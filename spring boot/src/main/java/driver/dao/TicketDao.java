package driver.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import driver.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

}
