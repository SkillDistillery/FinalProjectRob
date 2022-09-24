package com.skilldistillery.booknerds.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.booknerds.entities.Book;
import com.skilldistillery.booknerds.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
}
