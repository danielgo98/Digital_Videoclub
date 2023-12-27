package com.dab.videoclub.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dab.videoclub.dto.UserDTO;
import com.dab.videoclub.entities.User;
import com.dab.videoclub.services.UserService;
import com.dab.videoclub.utils.UserToUserDTO;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id){
		
		var user = userService.findById(id);
		
		if(user == null) {
			var errorMap = new HashMap<>();
			errorMap.put("error", "User with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		UserDTO userDTO = UserToUserDTO.convertToDTO(user);
		return ResponseEntity.status(HttpStatus.FOUND).body(userDTO);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
		
		var user = UserToUserDTO.converToDomain(userDTO);
		userService.save(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UserDTO userDTO , @PathVariable("id") Long id){
		
		if(!userDTO.getId().equals(id)) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", "Ids not equals");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
		}
		
		User user = userService.findById(id);
		
		if(user == null) {
			var errorMap = new HashMap<>();
			errorMap.put("Error", "User with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
		}
		
		var userSaved = UserToUserDTO.converToDomain(userDTO);
		userService.save(userSaved);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		var user = userService.findById(id);
		
		if(user == null) {
			
			var errorMap = new HashMap<>();
			errorMap.put("Error", "User with id " + id + " not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
			
		}
		
		userService.delete(user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
