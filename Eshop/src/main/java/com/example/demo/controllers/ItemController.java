package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	@PostMapping
	public ResponseEntity<Item> saveItem(@RequestBody Item item){
		return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);	
	}
	
	@GetMapping
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Item> getItemById(@PathVariable("id") long itemId){
		return new ResponseEntity<Item>(itemService.getItemById(itemId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Item> updateItem(@PathVariable("id") long itemId, @RequestBody Item item){
		return new ResponseEntity<Item>(itemService.updateItem(item ,itemId), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id") long itemId){
		itemService.deleteItem(itemId);
		
		return new ResponseEntity<String>("Item deleted succesfully!.", HttpStatus.OK);
	}
}
