package com.skilldistillery.booknerds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.booknerds.entities.User;
import com.skilldistillery.booknerds.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User updateUser(String username, User user) {
		User currentUser = userRepo.findByUsername(username);
		if (currentUser != null) {
			currentUser.setAboutMe(user.getAboutMe());
			currentUser.setDateOfBirth(user.getDateOfBirth());
			currentUser.setFirstName(user.getFirstName());
			currentUser.setLastName(user.getLastName());
			currentUser.setProfileImageUrl(user.getProfileImageUrl());
			if (user.getAddress() != null) {
				currentUser.setAddress(user.getAddress());
			}
			//TODO: favorite books
			if (user.getFavoriteBooks() != null) {
				currentUser.setFavoriteBooks(user.getFavoriteBooks());
			}
			return userRepo.saveAndFlush(currentUser);
		}
		return null;
	}
	
	@Override
	public boolean addFavoriteBook(String username, int bookId) {
		boolean added = false;
		return added;
	}

	@Override
	public boolean removeFavoriteBook(String username, int bookId) {
		boolean removed = false;
		return removed;
	}
	
}
