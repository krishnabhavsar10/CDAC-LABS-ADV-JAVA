package com.ticket.services;

import java.util.List;

import com.ticket.dto.TicketDTO;

public interface TicketService {
	public boolean createNewTicket(TicketDTO dto);
	public boolean updateTicket(Integer id, TicketDTO dto);
	public List<TicketDTO> getAllOpenTickets();
	public TicketDTO getTicketById(Integer id);
}
