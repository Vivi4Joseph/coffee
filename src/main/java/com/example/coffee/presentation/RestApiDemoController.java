package com.example.coffee.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee.model.Coffee;
import com.example.coffee.repository.CoffeeRepository;
import com.example.coffee.service.ICoffeeService;

@RestController
public class RestApiDemoController {
	private ICoffeeService coffeeService;
//	private List<Coffee> coffees = new ArrayList<>();

	public RestApiDemoController(ICoffeeService coffeeService) {
	super();
	this.coffeeService = coffeeService;
}
	@GetMapping("/coffees")
	public List<Coffee> getCoffees() {
			return coffeeService.getCoffees();
	}
	
	

	@PostMapping("/coffees")
	public  Coffee postCoffee(@RequestBody Coffee coffee) {
		return coffeeService.postCoffee(coffee);
	}
	
	@GetMapping("/coffees/{id}")
//	public Optional<Coffee> getCoffeById(@PathVariable String id) {
	public Optional<Coffee> getCoffeById(@PathVariable String id) {
		return coffeeService.getCoffeById(id);
	}
	
	@PutMapping("/coffees/{id}")
	public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		return coffeeService.putCoffee(id, coffee);
	}
	
	@DeleteMapping("/coffees/{id}")
	public void deleteCoffee(@PathVariable String id) {
		 coffeeService.deleteCoffee(id);
	}
	
	@GetMapping("/coffees/name/{name}")
	public Optional<Coffee> getByNames(@PathVariable String name){
		return coffeeService.GetByName(name);
	}
//	
//	
//	@PostMapping("/coffees/put")
//	public  Coffee postCoffeeByName(@RequestBody Coffee coffee) {
//		return coffeeRepository.postCoffeeByName(coffee);
//	}
//	
//	@GetMapping("/coffees/get/{id}")
////	public Optional<Coffee> getCoffeById(@PathVariable String id) {
//	public Optional<Coffee> getCoffeByName(@PathVariable String name) {
//		return coffeeRepository.getCoffeByName(name);
//	}
//	
//	@PutMapping("/coffees/put/{id}")
//	public ResponseEntity<Coffee> putCoffeeByName(@PathVariable String name, @RequestBody Coffee coffee) {
//		return coffeeRepository.putCoffeeByName(name, coffee);
//	}
//	
//	@DeleteMapping("/coffees/delete/{id}")
//	public void deleteCoffeeByName(@PathVariable String name) {
//		 coffeeRepository.deleteCoffeeByName(name);
//	}
}


