package fi.resthiberapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.resthiberapp.dto.UsersDTO;
import fi.resthiberapp.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController 
{
	@Autowired
	UsersService usersService;
	
	@GetMapping("/getUserDetails")
	public UsersDTO getUserDetails(@RequestParam("uName")String userName)
	{
		return usersService.getUsersByName(userName);
	}
	
	@GetMapping("/allUsers/{pageNo}/{pageSize}")
	public List<UsersDTO> allUsers(@PathVariable("pageNo")int pageNo,
							@PathVariable("pageSize")int pageSize)
	{
		return usersService.allUsers(pageNo, pageSize);
	}
}










