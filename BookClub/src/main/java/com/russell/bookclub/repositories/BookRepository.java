package com.russell.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.russell.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}