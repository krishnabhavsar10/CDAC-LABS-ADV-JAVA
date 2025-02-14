package fi.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.springmvc.beans.Users;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Users objUsers= new Users();
		objUsers.setUserName(rs.getString("userName"));
		objUsers.setPassword(rs.getString("password"));
		objUsers.setName(rs.getString("name"));
		objUsers.setEmail(rs.getString("email"));
		return objUsers;
	}

}





