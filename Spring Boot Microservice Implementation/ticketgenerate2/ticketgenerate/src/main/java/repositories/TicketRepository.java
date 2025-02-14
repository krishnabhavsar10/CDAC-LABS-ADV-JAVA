package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Ticket;
//import jakarta.persistence.Id;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	

}
