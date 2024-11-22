package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.entities.User;
import com.devsuperior.dslist.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
	    List<User> result = repository.findAll();
	    return ResponseEntity.ok(result);
	}
	
	
	// Uso
	// http://localhost:8080/users/page?page
	// http://localhost:8080/users/page?page=0&size=12&sort=name,desc
	@GetMapping(value="/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
	    Page<User> result = repository.findAll(pageable);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<User>> searchBySalary(
			@RequestParam(defaultValue = "0") Double minSalary, 
			@RequestParam(defaultValue = "1000000000000") Double maxSalary, 
			Pageable pageable) {
	    Page<User> result = repository.searchSalary(minSalary, maxSalary, pageable);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<User>> searchByName(
			@RequestParam(defaultValue = "") String name, 
			Pageable pageable) {
	    Page<User> result = repository.searchName(name, pageable);
	    return ResponseEntity.ok(result);
	}

}
