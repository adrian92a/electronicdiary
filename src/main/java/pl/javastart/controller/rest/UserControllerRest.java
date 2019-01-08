package pl.javastart.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javastart.repository.UsersRepository;

public class UserControllerRest {
	private UsersRepository userRepo;
	 
	
	@Autowired
	public UserControllerRest(UsersRepository userRepo) 
	{
		this.userRepo=userRepo;
	}
	
	
	
}
