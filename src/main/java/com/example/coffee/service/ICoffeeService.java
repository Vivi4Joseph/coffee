package com.example.coffee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coffee.model.Coffee;

public interface ICoffeeService {

	List<Coffee> getCoffees();

	Coffee postCoffee(Coffee coffee);

	//	public Optional<Coffee> getCoffeById(@PathVariable String id) {
	Optional<Coffee> getCoffeById(String id);

	ResponseEntity<Coffee> putCoffee(String id, Coffee coffee);

	void deleteCoffee(String id);
	
	//List<Coffee> GetByName(String name);

	Optional<Coffee> GetByName(String name);
}