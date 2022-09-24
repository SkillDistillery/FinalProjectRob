package com.skilldistillery.booknerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.booknerds.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
