package com.example.libraryManagement.Service;

import com.example.libraryManagement.model.Book;
import com.example.libraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    // Create or Update
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    // Delete book
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}