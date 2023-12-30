package com.dab.videoclub.exceptions;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = -8716938895148008685L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
