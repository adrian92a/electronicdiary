package pl.javastart.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javastart.repository.UserRepository;

public class UserControllerRest {
	private UserRepository userRepo;
	 
	
	@Autowired
	public UserControllerRest(UserRepository userRepo) 
	{
		this.userRepo=userRepo;
	}
}
