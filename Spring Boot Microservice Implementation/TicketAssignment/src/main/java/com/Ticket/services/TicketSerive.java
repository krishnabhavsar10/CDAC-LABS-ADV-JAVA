package com.Ticket.services;

import java.time.LocalDateTime;
import java.util.List;

import com.Ticket.dto.TicketDTO;

public interface TicketSerive {
	public boolean createNewTicket(TicketDTO dto);
	public TicketDTO updateTicket(int ticketId, String status, String resolutionDetails, LocalDateTime resolutionDateTime);
	public List<TicketDTO> allOpenTickets();
	public TicketDTO getTicketById(int id);
}
