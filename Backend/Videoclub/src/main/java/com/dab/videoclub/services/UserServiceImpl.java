package com.dab.videoclub.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dab.videoclub.entities.User;
import com.dab.videoclub.exceptions.UserNotFoundException;
import com.dab.videoclub.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(long id) {
		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	@Override
	public User findUser(String username, String password) throws UserNotFoundException {
		
		User user = userRepository.findUser(username, password);
		
		if(user == null) {
			throw new UserNotFoundException("User with username " + username + " and password " + password + " not found");
		}
		
		return user;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
