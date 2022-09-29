package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
		
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(long id) {
		return categoryRepository.findById(id).orElseThrow(() ->
						new ResourceNotFoundException("Category", "id", id));
	}

	@Override
	public Category updateCategory(Category category, long id) {
		
		Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
						new ResourceNotFoundException("Category", "id", id));
		
		existingCategory.setCategoryName(category.getCategoryName());
		
		categoryRepository.save(existingCategory);
		return existingCategory;
	}

	@Override
	public void deleteCategory(long id) {
		categoryRepository.findById(id).orElseThrow(() ->
					new ResourceNotFoundException("Category", "id", id));
		
		categoryRepository.deleteById(id);
	}
	
	
	

}
