package com.example.libraryManagement.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Library{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long libraryId;
	
	private String libraryName;
	private String libraryLocation;
	
	

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "library_books", // Table name
            joinColumns = @JoinColumn(name = "libraryId"), // Foreign key to Library
            inverseJoinColumns = @JoinColumn(name = "bookId") // Foreign key to Book
    )
    private List<Book> listOfBooks;
    public Library() {}

	public Library(Long libraryId, String libraryName, String libraryLocation, List<Book> listOfBooks) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryLocation = libraryLocation;
		this.listOfBooks = listOfBooks;
	}
	public Long getLibraryId() {
		return libraryId;
	}


	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}


	public String getLibraryName() {
		return libraryName;
	}


	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}


	public String getLibraryLocation() {
		return libraryLocation;
	}


	public void setLibraryLocation(String libraryLocation) {
		this.libraryLocation = libraryLocation;
	}


	public List<Book> getListOfBooks() {
		return listOfBooks;
	}


	public void setListOfBooks(List<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

}
