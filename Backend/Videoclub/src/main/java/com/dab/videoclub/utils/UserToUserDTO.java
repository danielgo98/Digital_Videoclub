package com.dab.videoclub.utils;

import com.dab.videoclub.dto.UserDTO;
import com.dab.videoclub.entities.User;

public class UserToUserDTO {
	
	public static UserDTO convertToDTO(User user) {
	
		UserDTO dto = UserDTO.builder()
				.id(user.getId())
				.email(user.getEmail())
				.password(user.getPassword())
				.username(user.getUsername())
				.build();

		
		return dto;
	}
	
	public static User converToDomain(UserDTO dto) {
		
		User user = User.builder()
				.id(dto.getId())
				.email(dto.getEmail())
				.password(dto.getPassword())
				.username(dto.getUsername())
				.build();
		
		return user;
	}
}