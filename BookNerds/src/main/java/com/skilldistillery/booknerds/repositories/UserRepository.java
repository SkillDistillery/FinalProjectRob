package com.skilldistillery.booknerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.booknerds.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserById(int userId);
	User findByUsername(String username);
}
