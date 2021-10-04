package com.nayan.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "BOOKS")
/*
 * Model Class
 */
public class BookModel {
	@Id
	private int bookID;
	private String title;
	private String authors;
	private String average_rating;
	private String isbn;
	private String language_code;
	private String ratings_count;
	private int price;

}
