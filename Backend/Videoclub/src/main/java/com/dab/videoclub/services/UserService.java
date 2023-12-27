package com.dab.videoclub.services;

import com.dab.videoclub.entities.User;

public interface UserService {
	
	User findById(long id);
	
	User save(User user);
	
	void delete(User user);

}