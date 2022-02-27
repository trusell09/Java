package com.russell.bookclub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.russell.bookclub.models.Book;
import com.russell.bookclub.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
    
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
    }
	
	public List<Book> allBooks() {
		return (List<Book>)this.bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	public Book updateBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public void deleteBook(Long id) {
		this.bookRepo.deleteById(id);
	}
}