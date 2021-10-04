package com.nayan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nayan.model.BookModel;
import com.nayan.service.BookService;

@RestController

public class BookController {

	@Autowired
	private BookService bookService;

	/*
	 * Get all books
	 */

	@GetMapping("/")
	public List<BookModel> viewAllBookDetails() {
		return bookService.getAll();
	}

	/*
	 * Get a book by ID
	 */

	@GetMapping("/search/{bookID}")
	public BookModel getById(@PathVariable int bookID) {
		return bookService.getById(bookID);
	}

	/*
	 * Get a book by term
	 */

	@GetMapping("/searchbyterm/{term}")
	public List<BookModel> filterByTerm(@PathVariable String term) {
		return bookService.getAllBooksByTitleTerm(term);
	}

}
