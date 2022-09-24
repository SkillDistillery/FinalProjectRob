package com.skilldistillery.booknerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.booknerds.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
