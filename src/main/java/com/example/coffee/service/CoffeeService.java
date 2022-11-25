package com.example.coffee.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coffee.model.Coffee;
import com.example.coffee.repository.CoffeeRepository;

@Service
public class CoffeeService implements ICoffeeService {
	private CoffeeRepository coffeeRepository;

	public CoffeeService(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}
	
	@PostConstruct
	private void loaddata() {
		coffeeRepository.saveAll(List.of(new Coffee("Distributeur"),
				new Coffee("Robusta"),
				new Coffee("Espresso"),
				new Coffee("Capushino")));
	
	}
	
	
	@Override
	public List<Coffee> getCoffees() {
		return coffeeRepository.findAll();
	}
	
	
	@Override
	public  Coffee postCoffee(@RequestBody Coffee coffee) {
		return coffeeRepository.save(coffee);
	}
	
	
//	public Optional<Coffee> getCoffeById(@PathVariable String id) {
	@Override
	public Optional<Coffee> getCoffeById(@PathVariable String id) {
		return coffeeRepository.findById(id);
	}
	
	
	@Override
	public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
//		int coffeeIndex=-1;
//			for(Coffee c: coffees) {
//				if(c.getId().equals(id)) {
//					coffeeIndex = coffees.indexOf(c);
//					
//					coffees.set(coffeeIndex, coffee);
//				}
//			}
//			return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee),HttpStatus.CREATED): 
//				new ResponseEntity<>(coffee , HttpStatus.OK);
	return (coffeeRepository.existsById(id)) ? new ResponseEntity<>(coffeeRepository.save(coffee),HttpStatus.CREATED):
		new ResponseEntity<>(coffeeRepository.save(coffee),HttpStatus.OK);
	}
	
	
	@Override
	public void deleteCoffee(@PathVariable String id) {
		coffeeRepository.deleteById(id);
	}

	@Override
	public Optional<Coffee> GetByName(String name) {
		return coffeeRepository.findByName(name);
	}

	//@Override
//	public List<Coffee> GetByName(String name) {
//
//		return coffeeRepository.findByName(name);
//	}
	
	
}
