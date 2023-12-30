package com.dab.videoclub.services;

import com.dab.videoclub.entities.User;
import com.dab.videoclub.exceptions.UserNotFoundException;

public interface UserService {
	
	User findById(long id);
	
	User findUser(String username, String password) throws UserNotFoundException;
	
	User save(User user);
	
	void delete(User user);

}