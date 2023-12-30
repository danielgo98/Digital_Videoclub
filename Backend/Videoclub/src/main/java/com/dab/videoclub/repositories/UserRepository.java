package com.dab.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dab.videoclub.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
	User findUser(@Param("username")String username, @Param("password") String password);

}
