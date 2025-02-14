package fi.secondspringapp.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("objUser")
public class Users 
{
	String userName ;
	
	String password ;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@PostConstruct
	public void initialize()
	{
		System.out.println("initialize method of Users fired.....");
	}
	
	@PreDestroy
	public void releaseResource()
	{
		System.out.println("releasing all the resources with Users object");
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
