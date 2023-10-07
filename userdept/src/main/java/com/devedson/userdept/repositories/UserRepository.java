package com.devedson.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devedson.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
