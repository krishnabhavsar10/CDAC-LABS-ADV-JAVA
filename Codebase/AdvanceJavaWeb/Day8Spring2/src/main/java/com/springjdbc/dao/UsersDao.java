package com.springjdbc.dao;

import java.util.Iterator;

import com.springjdbc.beans.Users;

public interface UsersDao {
	public boolean registerUser(String userName, String password, String name, String email);
	public boolean changePassword(String userName, String password);
	public Users getUserDetails(String username);
	public Iterator<Users> getAllUsers();
}
