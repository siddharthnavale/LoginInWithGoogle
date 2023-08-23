package com.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.User;



@Repository
public interface User_Repository extends JpaRepository<User, Long> {

	public User findByusername(String username);
	
	public User findByemail(String email);



}
