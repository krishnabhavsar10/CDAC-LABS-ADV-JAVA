package fi.resthiberapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fi.resthiberapp.dto.UsersDTO;
import fi.resthiberapp.entity.Users;
import fi.resthiberapp.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService 
{
	@Autowired
	UsersRepository usersRepo;
	
	
	@Override
	public UsersDTO getUsersByName(String userName) {
		Users entityUsers = usersRepo.findById(userName).get();
		UsersDTO dto = new UsersDTO();
		BeanUtils.copyProperties(entityUsers, dto);
		return dto;
	}

	@Override
	public List<UsersDTO> allUsers(int pageNo, int pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		List<Users> allUsersPage = usersRepo.findAll(page).toList();
		
		ArrayList<UsersDTO> dtoList = new ArrayList<>();
		for(Users entUsers : allUsersPage)
		{
			UsersDTO dto = new UsersDTO();
			BeanUtils.copyProperties(entUsers, dto);
			dtoList.add(dto);			
		}
		return dtoList;
	}

}
