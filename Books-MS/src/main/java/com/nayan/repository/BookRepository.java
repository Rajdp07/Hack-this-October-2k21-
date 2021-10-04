package com.nayan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nayan.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Integer> {

BookModel findByBookID(int bookID);


}
