package com.ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.dto.TicketDTO;
import com.ticket.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;

	@PostMapping("/createNewTicket")
	public boolean createNewTicket(@RequestBody TicketDTO dto) {
		return ticketService.createNewTicket(dto);
	}

	@PutMapping("/updateTicket/{id}")
	public boolean updateTicket(@PathVariable("id") Integer id, @RequestBody TicketDTO dto) {
		return ticketService.updateTicket(id, dto);
	}

	@GetMapping("/getAllOpenTickets")
	public List<TicketDTO> getAllOpenTickets() {
		return ticketService.getAllOpenTickets();
	}

	@GetMapping("/getTicketById/{id}")
	public TicketDTO getTicketById(@PathVariable("id") Integer id) {
		return ticketService.getTicketById(id);
	}
}

