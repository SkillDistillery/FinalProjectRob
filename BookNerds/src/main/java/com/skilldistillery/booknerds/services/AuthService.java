package com.skilldistillery.booknerds.services;

import com.skilldistillery.booknerds.entities.User;

public interface AuthService {
	public User register(User user);
	public User getUserByUsername(String username);
	User getUserById(int userId);
}
