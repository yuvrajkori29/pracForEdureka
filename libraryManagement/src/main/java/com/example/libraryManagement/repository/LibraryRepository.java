package com.example.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.libraryManagement.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long>{
	
}