package com.nayan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nayan.model.BookModel;
import com.nayan.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	/*
	 * Get All Books
	 */
	public List<BookModel> getAll() {
		return bookRepo.findAll();
	}

	/*
	 * Save All Books by Reading JSON
	 */
	public void saveBooks(List<BookModel> books) {
		bookRepo.saveAll(books);
	}

	/*
	 * Get a book by ID
	 */
	public BookModel getById(int bookID) {
		return bookRepo.findByBookID(bookID);
	}

	/*
	 * Filter a Book Title By Term
	 */

	public List<BookModel> getAllBooksByTitleTerm(String term) {
		List<BookModel> allBooks = getAll();
		List<BookModel> filteredBooksWithTerm = new ArrayList<>();

		for (BookModel m : allBooks) {
			if (m.getTitle().contains(term) == true) {
				filteredBooksWithTerm.add(m);
			}
		}

		return filteredBooksWithTerm;

	}

}
