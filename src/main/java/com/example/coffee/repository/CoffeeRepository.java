package com.example.coffee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coffee.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, String>{
	
	Optional<Coffee> findByName(String name);
	

}
