package com.dab.videoclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dab.videoclub.entities.User;
import com.dab.videoclub.repositories.UserRepository;
import com.dab.videoclub.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Test
	public void testFindByIdWithValidId() {
		
		User expectedUser = new User();
		
		when(userRepository.findById(anyLong()))
		.thenReturn(Optional.of(expectedUser));
		
		User actualUser = userService.findById(1);
		
		assertEquals(expectedUser, actualUser);
		
	}
	
	@Test
	public void testFindByIdWithInvalidId() {
		
		when(userRepository.findById(anyLong()))
		.thenReturn(Optional.empty());
		
		User user = userService.findById(Long.MAX_VALUE);
		
		assertNull(user);
		
	}
}
