package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.Entity.Provider;
import com.demo.Entity.User;
import com.demo.Repository.User_Repository;

@SpringBootApplication
public class LoginWithGoogleApplication implements CommandLineRunner {

	@Autowired
	User_Repository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(LoginWithGoogleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1= new User();
		user1.setUsername("Siddharth");
		user1.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user1.setEmail("sid@gmail.com");
		user1.setRole("ROLE_NORMAL");
		user1.setProvider(Provider.LOCAL);
		userRepository.save(user1);
		
		User user2= new User();
		user2.setUsername("Mudassir");
		user2.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user2.setEmail("mudassir@gmail.com");
		user2.setRole("ROLE_ADMIN");
		user2.setProvider(Provider.LOCAL);
		userRepository.save(user2);
	
		
		
	}

}
