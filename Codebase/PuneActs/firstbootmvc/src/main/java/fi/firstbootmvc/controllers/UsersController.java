package fi.firstbootmvc.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.firstbootmvc.entity.Users;

@Controller
public class UsersController 
{
	@Autowired
	SessionFactory hibernateFactory;
	
	@RequestMapping("/login")
	public void prepareUsers(Model data)
	{
		Users objUser = new Users();
		data.addAttribute("objUser",objUser);
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authenticate(@ModelAttribute("objUser")Users objUser)
	{
		try(Session hibernateSession = hibernateFactory.openSession())
		{
			Users dbUsers = (Users)hibernateSession.get(Users.class, objUser.getUserName());
			if(dbUsers.getPassword().equals(objUser.getPassword()))
				return new ModelAndView("welcome","data","WElocme to onlin boot mvc app");
			else
				return new ModelAndView("failure","data","Please login again");
						
		}
	}
}









