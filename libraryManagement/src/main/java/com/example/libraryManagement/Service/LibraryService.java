package com.example.libraryManagement.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.libraryManagement.model.Library;
import com.example.libraryManagement.repository.BookRepository;
import com.example.libraryManagement.repository.LibraryRepository;

@Service
public class LibraryService{
	
	
	@Autowired
	private final LibraryRepository libraryRepo;

    @Autowired
    private final BookRepository bookRepo;

    public LibraryService(LibraryRepository libraryRepo, BookRepository bookRepo) {
        this.libraryRepo = libraryRepo;
        this.bookRepo = bookRepo;
    }
	
	
	
	//method to add library
	public  Library addLibrary(Library newLibrary)
	{
		return libraryRepo.save(newLibrary);	
	}
	
	//method to delete a library
	public void deleteLibrary(Long libraryId)
	{
		libraryRepo.deleteById(libraryId);

	}
	
	//methods to update library
	public Optional<Library> updateLibrary(Long libraryId,Library newLibrary)
	{
		
	Optional<Library> toUpdate = libraryRepo.findById(libraryId);
	
	if(toUpdate.isPresent()) {
		Library library = toUpdate.get();
		
		 String libraryName = newLibrary.getLibraryName();
		 library.setLibraryName(libraryName);
		 
		 String libraryLocation  = newLibrary.getLibraryLocation();
		 library.setLibraryLocation(libraryLocation);
		 
		 libraryRepo.save(library);
		
		 return Optional.of(library);
	}
	
	else
	{
      return Optional.empty();
	}
	
	}
	
	//method to read library
	public Optional<Library> getLibrary(Long libraryId)
	{
		Optional<Library> toRead = libraryRepo.findById(libraryId);
		
		if(toRead.isPresent())return toRead;

	else return Optional.empty();
	}

	
	
}
