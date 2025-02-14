package com.Ticket.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ticket.dto.TicketDTO;
import com.Ticket.entity.Ticket;
import com.Ticket.entity.Ticket.Status;
import com.Ticket.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketSerive {
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public boolean createNewTicket(TicketDTO dto) {
		Ticket ticket = dto.toEntity();
		ticketRepository.save(ticket);
		return true;
	}

	@Override
	public List<TicketDTO> allOpenTickets() {
		ArrayList<TicketDTO> dtoList = new ArrayList<TicketDTO>();
		
		List<Ticket> entityList = ticketRepository.findOpenTicketsNative(Status.OPEN.name());
		
		for(Ticket ticket : entityList) {
			dtoList.add(TicketDTO.fromEntity(ticket));
		}
		
		return dtoList;
	}

	@Override
	public TicketDTO getTicketById(int id) {
		Optional<Ticket> entityTicket = ticketRepository.findById(id);
		
		if(entityTicket.isPresent()) {
			TicketDTO dto = TicketDTO.fromEntity(entityTicket.get());
			return dto;
		}
		else {
			return null;
		}
	}

	@Override
	@Transactional
	public TicketDTO updateTicket(int ticketId, String status, String resolutionDetails, LocalDateTime resolutionDateTime) {
	    // Fetch the ticket from the database
	    Ticket ticket = ticketRepository.findById(ticketId)
	            .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + ticketId));

	    // Handle status: Update the status if valid, else throw an exception or use default status
	    if (status != null) {
	        try {
	            ticket.setStatus(Ticket.Status.valueOf(status)); // Validate enum value
	        } catch (IllegalArgumentException e) {
	            // Handle invalid enum value, e.g., set default status or throw custom exception
	            throw new RuntimeException("Invalid status value: " + status);
	        }
	    }

	    // Update resolution details if provided
	    if (resolutionDetails != null) {
	        ticket.setResolutionDetails(resolutionDetails);
	    }

	    // Handle resolutionDateTime: If it's null or invalid, set it to the current date-time
	    if (resolutionDateTime == null) {
	        ticket.setResolutionDateTime(LocalDateTime.now()); // Set to current date-time if null
	    } else {
	        try {
	            // Optionally, you could validate the format of the date-time here if required
	            ticket.setResolutionDateTime(resolutionDateTime); // If provided, set it
	        } catch (Exception e) {
	            // If invalid, set to the current date-time
	            ticket.setResolutionDateTime(LocalDateTime.now());
	        }
	    }

	    // Save the updated ticket
	    Ticket updatedTicket = ticketRepository.save(ticket);

	    // Convert the updated ticket to DTO and return
	    return TicketDTO.fromEntity(updatedTicket);
	}


}