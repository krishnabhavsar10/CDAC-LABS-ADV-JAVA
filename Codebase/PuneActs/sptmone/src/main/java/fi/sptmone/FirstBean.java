package fi.sptmone;

import org.springframework.stereotype.Component;

@Component("objBean")
public class FirstBean 
{
	String userName;
	String password;
	
	public FirstBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
