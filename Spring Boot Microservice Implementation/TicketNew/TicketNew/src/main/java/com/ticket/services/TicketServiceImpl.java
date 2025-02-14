package com.ticket.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.dto.TicketDTO;
import com.ticket.entity.Ticket;
import com.ticket.exception.TicketNotFoundException;
import com.ticket.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public boolean createNewTicket(TicketDTO dto) {
		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(dto, ticket);
		ticketRepository.save(ticket);
		return true;
	}

	@Override
	public boolean updateTicket(Integer id, TicketDTO dto) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		
		if(ticket.isPresent()) {
			ticket.get().setStatus(dto.getStatus());
			ticket.get().setResolveDetails(dto.getResolveDetails());
			ticket.get().setResolveDate(dto.getResolveDate());
			ticketRepository.save(ticket.get());
			return true;
		}
		else {
			throw new TicketNotFoundException("Ticket with ID " + id + " not found");
		}
		
	}

	@Override
	public List<TicketDTO> getAllOpenTickets() {
		List<Ticket> ticketList = ticketRepository.findAllOpenTickets();
		
		if (ticketList.isEmpty()) {
            throw new TicketNotFoundException("No open tickets found");
        }
		
		ArrayList<TicketDTO> dtoList = new ArrayList<TicketDTO>();
		for(Ticket ticket : ticketList) {
			TicketDTO dto = new TicketDTO();
			BeanUtils.copyProperties(ticket, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public TicketDTO getTicketById(Integer id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		
		if(ticket.isPresent()) {
			TicketDTO dto = new TicketDTO();
			BeanUtils.copyProperties(ticket.get(), dto);
			return dto;
		}
		else {
			throw new TicketNotFoundException("Ticket with ID " + id + " not found");
		}
	}

}
