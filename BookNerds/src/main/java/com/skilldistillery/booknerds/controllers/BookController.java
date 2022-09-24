package com.skilldistillery.booknerds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.booknerds.entities.Book;
import com.skilldistillery.booknerds.services.BookService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class BookController {
	
	@Autowired
	private BookService bookSvc;

	@GetMapping("books")
	public List<Book> index() {
		return bookSvc.allBooks();
	}

}
