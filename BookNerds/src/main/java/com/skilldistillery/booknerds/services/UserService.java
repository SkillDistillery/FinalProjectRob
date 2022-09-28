package com.skilldistillery.booknerds.services;

import com.skilldistillery.booknerds.entities.User;

public interface UserService {
	
	User updateUser(String username, User user);

	boolean addFavoriteBook(String username, int bookId);

	boolean removeFavoriteBook(String username, int bookId);

}
