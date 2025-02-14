package com.Ticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ticket.dto.TicketDTO;
import com.Ticket.services.TicketSerive;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketSerive ticketService;
	
	@PostMapping("/createNewTicket")
	public boolean createNewTicket(@RequestBody TicketDTO dto) {
		return ticketService.createNewTicket(dto);
	}
	
	@GetMapping("/getTicketById")
	public TicketDTO getTicketById(@RequestParam("id") int id) {
		return ticketService.getTicketById(id);
	}
	
	@GetMapping("/allOpenTickets")
	public List<TicketDTO> allOpenTickets(){
		return ticketService.allOpenTickets();
	}
	
	@PutMapping("/updateTicket/{id}")
	public TicketDTO updateTicket(@PathVariable("id") int id, @RequestBody TicketDTO dto) {
	    return ticketService.updateTicket(id, dto.getStatus(), dto.getResolutionDetails(), dto.getResolutionDateTime());
	}	
}
