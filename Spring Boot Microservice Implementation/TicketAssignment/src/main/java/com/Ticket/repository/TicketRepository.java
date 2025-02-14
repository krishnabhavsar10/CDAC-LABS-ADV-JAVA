package com.Ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    // Native SQL query to fetch all open tickets
    @Query(value = "SELECT * FROM ticket WHERE status = :status", nativeQuery = true)
    List<Ticket> findOpenTicketsNative(@Param("status") String status);

    // Native SQL query to fetch all closed tickets
    @Query(value = "SELECT * FROM ticket WHERE status = :status", nativeQuery = true)
    List<Ticket> findClosedTicketsNative(@Param("status") String status);
}

