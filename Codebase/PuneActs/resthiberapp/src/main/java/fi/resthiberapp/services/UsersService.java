package fi.resthiberapp.services;

import java.util.List;

import fi.resthiberapp.dto.UsersDTO;

public interface UsersService 
{
	public UsersDTO getUsersByName(String userName);
	public List<UsersDTO> allUsers(int pageNo, int pageSize);
}
