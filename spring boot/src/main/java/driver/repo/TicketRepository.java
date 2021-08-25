package driver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import driver.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
