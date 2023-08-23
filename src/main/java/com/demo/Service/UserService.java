package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Provider;
import com.demo.Entity.User;
import com.demo.Repository.User_Repository;

@Service
public class UserService {
	
	@Autowired
	private User_Repository userRepository;
	
	
	
	
	public List <User> getAllUser(){

		return this.userRepository.findAll();
		
	}
	
	public User getUserById(int UserId){
		List <User>  userList= userRepository.findAll();
		for(User user:userList) {
			if(user.getId()==UserId) {
			return	user;
			}
		}
		return null;
	}
	
	
	public String addUser(User user) {
		
		this.userRepository.save(user);
		return "User details added successfully";
		
	}

	public User findByEmail(String email) {
		User user=userRepository.findByemail(email);
		return user;
	}

	public void createNewUserAfterOuathLogin(String name, String email, Provider provider) {
		User user =new User();
		user.setUsername(name);
		user.setEmail(email);
		user.setProvider(provider);
		userRepository.save(user);	
	}
	
}
