package com.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Implement a custom sql native query to fetch all tickets with status OPEN
    @Query(value = "SELECT * FROM ticket WHERE status = 'OPEN'", nativeQuery = true)
    public List<Ticket> findOpenTicketsNative();
    
    // Implement a custom JPA query to fetch all tickets with status OPEN
    @Query("SELECT t FROM Ticket t WHERE t.status = 'OPEN'")
    public List<Ticket> findAllOpenTickets();

    // Native SQL query to fetch all open tickets
    @Query(value = "SELECT * FROM ticket WHERE status = :status", nativeQuery = true)
    List<Ticket> findOpenTicketsNative(@Param("status") String status);
    
}
