package com.example.libraryManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Book{
	 @Id
	 @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long bookId;
	 
	 private String authorName;
	 private Double bookPrice;
	 private String bookName;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "library_id")
	 @JsonIgnore
	private Library library;
	 
	 
	 public Book() {}

	
	public Book(Long bookId, String authorName, Double bookPrice, String bookName, Library library) {
		super();
		this.bookId = bookId;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
		this.bookName = bookName;
		this.library = library;
	}
	
	

	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}



	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	 
	 
	  
	 
}