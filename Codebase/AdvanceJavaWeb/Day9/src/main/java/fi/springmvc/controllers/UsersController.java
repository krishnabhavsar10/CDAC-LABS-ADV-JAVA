package fi.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.springmvc.beans.Users;

@Controller
public class UsersController {
	
	@RequestMapping("/login")
	public void prepareUser(Model data) {
		Users objUser = new Users();
		data.addAttribute("objUser", objUser);
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView validateUser(@ModelAttribute("objUser") Users objUser) {
		if(objUser.getName().equals("krishna") && objUser.getPassword().equals("123")) {
			return new ModelAndView("welcome", "data", "Welcome " + objUser.getUserName());
		}
		else {
			return new ModelAndView("failure", "message", "Invalid authentication");
		}
	}
}
