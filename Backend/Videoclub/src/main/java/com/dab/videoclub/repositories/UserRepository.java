package com.dab.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dab.videoclub.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
