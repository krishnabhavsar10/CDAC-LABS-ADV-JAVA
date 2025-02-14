package fi.microuserservice.services;

import java.util.List;

import fi.microuserservice.dto.UsersDTO;

public interface UsersService {
	public UsersDTO getUserDetails(String userName);
	public List<UsersDTO> allUsers();
}
