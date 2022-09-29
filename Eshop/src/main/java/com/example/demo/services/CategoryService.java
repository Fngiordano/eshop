package com.example.demo.services;

import java.util.List;


import com.example.demo.models.Category;

public interface CategoryService {
	Category saveCategory(Category category);
	List<Category> getAllCategories();
	Category getCategoryById(long id);
	Category updateCategory(Category category, long id);
	void deleteCategory(long id);
}
