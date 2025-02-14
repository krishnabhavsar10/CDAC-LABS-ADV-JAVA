package fi.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class UsersController 
{
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public void prepareUser(Model data)
	{
		Users objUser = new Users();
		data.addAttribute("objUser",objUser);		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String checkUser(@Valid @ModelAttribute("objUser") Users objUser, BindingResult result)
	{
		if(result.hasErrors())
			return "login";
		else
			return "forward:authenticate";
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authenticateUser(@ModelAttribute("objUser")Users objUser)
	{
		if(objUser.getUserName().equals("cdac") && objUser.getPassword().equals("cdac"))
			return new ModelAndView("welcome","data","Welcome to online");
		else
			return new ModelAndView("failure","data","Failed authentication");
	}
	
	
	
	
}
