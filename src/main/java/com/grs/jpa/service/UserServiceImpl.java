package com.grs.jpa.service;

import org.springframework.stereotype.Service;

import com.grs.jpa.domain.SignupForm;
import com.grs.jpa.domain.User;
import com.grs.jpa.repository.UserRepository;




@Service
public class UserServiceImpl implements UserService {

	
	
	private UserRepository userRepository;
	
	public UserServiceImpl( UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	
	@Override
	public void signup(SignupForm signupForm) {
		
		User newUser = new User();
		
		newUser.setEmail(signupForm.getEmail());
		newUser.setName(signupForm.getUserName());
		newUser.setPassword(signupForm.getPassword());
		
		userRepository.save(newUser);

	}

}
