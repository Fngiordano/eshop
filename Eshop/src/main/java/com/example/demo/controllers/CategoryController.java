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

import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> getallCategories(){
		return categoryService.getAllCategories();
	}
	
	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long categoryId){
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long categoryId, @RequestBody Category category){
		return new ResponseEntity<Category>(categoryService.updateCategory(category, categoryId), HttpStatus.OK); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("id") long categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<String>("Category deleted succesfully!.", HttpStatus.OK);
	}
}
