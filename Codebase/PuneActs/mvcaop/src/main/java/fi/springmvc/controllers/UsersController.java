package fi.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController 
{
	@RequestMapping("/login")
	public void prepareUser(Model data)
	{
		Users objUser = new Users();
		data.addAttribute("objUser",objUser);		
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(@ModelAttribute("objUser")Users objUser)
	{
		System.out.println("user controller : " + this);
		if(objUser.getUserName().equals("cdac") && objUser.getPassword().equals("cdac"))
			return new ModelAndView("welcome","data","Welcome to online");
		else
			return new ModelAndView("failure","data","Failed authentication");
	}
	
	
	
	
}
