package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.TicketDto;
import entity.Status;
import entity.Ticket;
import repositories.TicketRepository;

@Service
public class ServiceImpl implements Services {

  @Autowired
  TicketRepository repository;
	@Override
	public boolean createTicket(TicketDto dto) {

		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(dto, ticket);
		System.out.println(dto);
		repository.save(ticket);
		
    	return true;
	}

	@Override
	public boolean updateTicket(Integer id ,TicketDto dto) {

		Optional<Ticket> ticket = repository.findById(id);
		if(ticket.isPresent()) {
			ticket.get().setStatus(dto.getStatus());
			ticket.get().setResolution(dto.getResolution());
			ticket.get().setResolvedate(dto.getResolvedate());
			repository.save(ticket.get());
			return true;
		}
		else {
                 return false;
		}
		
	}

	@Override
	public List<TicketDto> allTickets() {
         List<Ticket> list =  repository.findAll();
         System.out.println("list"+list);
         List<TicketDto> finalList = new ArrayList<>();
         
         for(Ticket t : list)
         {
        	 System.out.println(t);
        	 if(t.getStatus().equals(Status.OPEN))
        	 {
        	 TicketDto ticketdto = new TicketDto();
        	  BeanUtils.copyProperties(t,ticketdto);
              finalList.add(ticketdto);
        	 }
         }
		
		
		return finalList;
	}

	@Override
	public TicketDto fetchById(Integer id) {
    
		    Optional<Ticket> ticket = repository.findById(id);
//		    TicketDto dto = new TicketDto();
//		    BeanUtils.copyProperties(ticket , dto);
		    if (ticket.isPresent()) {
		        TicketDto dto = new TicketDto();
		        BeanUtils.copyProperties(ticket.get(), dto);  // Extract the Ticket object from Optional
		        return dto;
		    } else {
		        // Return null or throw an exception if ticket is not found
		        return null;  // or you can throw a custom exception like TicketNotFoundException
		    }
	
	}

}
