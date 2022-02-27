package com.russell.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.russell.bookclub.models.Book;
import com.russell.bookclub.models.User;
import com.russell.bookclub.services.BookService;
import com.russell.bookclub.services.UserService;

@Controller
public class BookController {
	private final BookService bookService;
    private final UserService userService;

	public BookController(BookService bookService, UserService userService) {
		this.bookService = bookService;
		this.userService = userService;
	}
	
    @RequestMapping("/books")
    public String home(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("loggedInUserID");
        if(id == null) {
            return "redirect:/";
        }
        User loggedInUser = this.userService.findOneUser(id);
        model.addAttribute("loggedInUser", loggedInUser);
        
        List<Book> allBooks = this.bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		
        return "book.jsp";
    }
    
    @RequestMapping("/books/new")
    public String newBook(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("loggedInUserID");
        if(id == null) {
            return "redirect:/";
        }
        User loggedInUser = this.userService.findOneUser(id);
        model.addAttribute("loggedInUser", loggedInUser);
        
        model.addAttribute("book", new Book());
        return "newBook.jsp";
    }
    
    @PostMapping("/books/create")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {

			return "newBook.jsp";
		}else {
			this.bookService.createBook(book);
			return "redirect:/books";
		}
    }
    
    @RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, HttpSession session, Model model) {
        Long user_id = (Long) session.getAttribute("loggedInUserID");
        if(user_id == null) {
            return "redirect:/";
        }
        User loggedInUser = this.userService.findOneUser(user_id);
        model.addAttribute("loggedInUser", loggedInUser);
		Book book = this.bookService.findBook(id);
		model.addAttribute("book", book);
		return "showOneBook.jsp";
	}
    
    @RequestMapping("/books/edit/{id}")
	public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
        Long user_id = (Long) session.getAttribute("loggedInUserID");
        if(user_id == null) {
            return "redirect:/";
        }
        User loggedInUser = this.userService.findOneUser(user_id);
        model.addAttribute("loggedInUser", loggedInUser);
		Book bookToEdit = this.bookService.findBook(id);
		model.addAttribute("bookToEdit", bookToEdit);
		if(loggedInUser.getId() != bookToEdit.getUser().getId()) return "redirect:/books";
		return "editBook.jsp";
	}
    
    @RequestMapping("/books/user/{id}")
    public String bookUser(@PathVariable("id") Long user_id, HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("loggedInUserID");
        if(id == null) {
            return "redirect:/";
        }
        User loggedInUser = this.userService.findOneUser(id);
        model.addAttribute("loggedInUser", loggedInUser);
        
        List<Book> allBooks = this.bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		
		User user = this.userService.findOneUser(user_id);
        model.addAttribute("user", user);
		
        return "user.jsp";
    }
    
    @PutMapping("/books/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("bookToEdit") Book bookEdit, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
			this.bookService.updateBook(bookEdit);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.bookService.deleteBook(id);
		return "redirect:/books";
	}
    
}
