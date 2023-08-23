package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.Entity.CustomUserDetails;
import com.demo.Entity.User;
import com.demo.Repository.User_Repository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private User_Repository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByusername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User is not found");
		}
		return new CustomUserDetails(user);
	}

}
