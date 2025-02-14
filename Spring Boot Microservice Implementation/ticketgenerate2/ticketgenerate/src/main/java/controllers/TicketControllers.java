package controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.TicketDto;
import services.Services;

@RestController
@RequestMapping("/ticket")

public class TicketControllers {

	@Autowired
	
	Services service;

	@GetMapping("/getallticket")
	public List<TicketDto> getallTickets()
	{
		return service.allTickets();
		
	}
	@PostMapping("/createticket")
	public boolean createticket(@RequestBody TicketDto dto)
	{
	    service.createTicket(dto);
	    return true;
	}
	
	@GetMapping("/getbyid/{id}")
	
	public TicketDto findById(@PathVariable("id") Integer id)
	{
		return service.fetchById(id);
		
	}
	
	@PutMapping("/update/{id}")
	public boolean updateticket(@PathVariable Integer id , @RequestBody TicketDto dto)
	{
		
		return service.updateTicket(id, dto);
	}
	
	
}
