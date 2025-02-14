package fi.firstrestapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController 
{
	@GetMapping("/home")
	public String welcome()
	{
		return "Welcome to the First REST application in Spring";
	}
	
	@GetMapping("/authenticate")
	public boolean authenticate(@RequestParam("userName")String userName,@RequestParam("password") String password)
	{
		if(userName.equals("cdac") && password.equals("cdac"))
			return true;
		else
			return false;
	}
}
