package fi.firstbootapp.beans;

import org.springframework.stereotype.Component;

@Component
public class Users {

	String userName;
	String password;
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
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
}
