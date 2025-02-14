package fi.microusersservice.services;

import java.util.List;

import fi.microusersservice.dto.UsersDTO;

public interface UsersService 
{
	public UsersDTO getUserDetails(String userName);
	public List<UsersDTO> allUsers();
}
