package fi.bootsecuredform;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController 
{
	@GetMapping("/accountpage")
	//@PreAuthorize("hasRole('USER')")
	public String accountInfo()
	{
		return "This is your Profile page for your account";
	}
}
