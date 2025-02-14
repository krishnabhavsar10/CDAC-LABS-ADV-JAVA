package fi.microuserservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.microuserservice.dto.UsersDTO;
import fi.microuserservice.entity.Users;
import fi.microuserservice.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public UsersDTO getUserDetails(String userName) {
		Optional<Users> optionalEntity = usersRepository.findById(userName);
		if(optionalEntity.isPresent()) {
			UsersDTO dto = new UsersDTO();
			BeanUtils.copyProperties(optionalEntity.get(), dto);
			return dto;
		}
		else {
			return null;
		}
	}

	@Override
	public List<UsersDTO> allUsers() {
		List<Users> list = usersRepository.findAll();
		ArrayList<UsersDTO> finalList = new ArrayList<>();
		
		for(Users entity : list) {
			UsersDTO dto = new UsersDTO();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		
		return finalList;
	}

}
