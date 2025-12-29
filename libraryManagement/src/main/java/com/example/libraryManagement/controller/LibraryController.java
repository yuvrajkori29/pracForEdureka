package com.example.libraryManagement.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagement.Service.LibraryService;
import com.example.libraryManagement.model.Library;

@RestController
@RequestMapping("/libraries")
public class LibraryController{
	  
	
	@Autowired
	private final LibraryService libraryServ;

	public LibraryController(LibraryService libraryServ) {
		super();
		this.libraryServ = libraryServ;
	}
	
	
	@GetMapping({"/library/{libraryId}"})
	public ResponseEntity<Optional<Library>> getLibray(@PathVariable Long libraryId)
	{
		Optional<Library> findLibrary = libraryServ.getLibrary(libraryId);
		
		if(findLibrary.isPresent())
		{
			return ResponseEntity.ok(findLibrary);
		}
		 return ResponseEntity.notFound().build();
	}
	
	  // POST mapping to create a new Library
	@PostMapping("/library")
    public ResponseEntity<Library> addLibrary(@RequestBody Library newLibrary) {
        Library savedLibrary = libraryServ.addLibrary(newLibrary);

        return ResponseEntity
                .created(URI.create("/library/" + savedLibrary.getLibraryId()))
                .body(savedLibrary);  // Return saved library including books
    }
	
	@DeleteMapping("/library/{libraryId}")
	public ResponseEntity<Void> deleteLibrary(@PathVariable Long libraryId) {
	    Optional<Library> library = libraryServ.getLibrary(libraryId);
	    
	    if (library.isPresent()) {
	        libraryServ.deleteLibrary(libraryId);
	        return ResponseEntity.noContent().build(); // Return 204 No Content on success
	    }
	    
	    return ResponseEntity.notFound().build(); // Return 404 if ID doesn't exist
	}
	
	
	
}