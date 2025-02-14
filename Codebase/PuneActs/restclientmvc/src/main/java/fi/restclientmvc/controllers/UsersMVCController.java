package fi.restclientmvc.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

@Controller
public class UsersMVCController 
{
	URI uri;
	
	RestTemplate restTemplate;
	
	@PostConstruct
	public void initializeRestClient()
	{
		try {
			uri = new URI("http://localhost/users/allUsers/0/1000");
			restTemplate = new RestTemplate();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/showusers")
	public String showAllUsers(Model data)
	{
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		data.addAttribute("users",response.getBody());
		return "showusers";
				
	}
	
	
}













