package fi.microusersservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.microusersservice.dto.UsersDTO;
import fi.microusersservice.entity.Users;
import fi.microusersservice.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService 
{
	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public UsersDTO getUserDetails(String userName) {
	
		Users entity = usersRepository.findById(userName).get();
		UsersDTO dto = new UsersDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<UsersDTO> allUsers() 
	{
		List<Users> list = usersRepository.findAll();
		ArrayList<UsersDTO> finalList = new ArrayList<>();
		for(Users entity : list)
		{
			UsersDTO dto = new UsersDTO();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		return finalList;
	}

}
