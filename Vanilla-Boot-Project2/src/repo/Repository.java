package repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Ticket;

public interface Repository extends JpaRepository<Ticket, Long> {
  List<Ticket> findByEmpId(int employee_id);
  List<Ticket> findByTicketId(long ticket_id);
}
