package services;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.TicketDto;


public interface Services {

	public boolean createTicket(TicketDto dto);
	public  boolean updateTicket(Integer ID ,TicketDto dto);
	public List<TicketDto> allTickets();
	public TicketDto fetchById(Integer id);
	
	
}
