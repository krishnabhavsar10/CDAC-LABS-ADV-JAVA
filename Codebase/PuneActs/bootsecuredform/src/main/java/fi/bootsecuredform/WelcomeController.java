package fi.bootsecuredform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/default")
public class WelcomeController 
{
	@GetMapping("/home")
	public String welcome()
	{
		return "Welcome to the Online Web Site";
	}
}
