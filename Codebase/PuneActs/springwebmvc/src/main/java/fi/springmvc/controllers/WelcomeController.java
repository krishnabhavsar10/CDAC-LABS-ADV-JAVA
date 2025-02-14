package fi.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController 
{
	@RequestMapping("/home")
	public ModelAndView welcome()
	{
		return new ModelAndView("home","message","Welcome to the First MVC application");
	}
}
