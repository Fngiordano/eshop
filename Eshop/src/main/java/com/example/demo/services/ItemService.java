package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Item;

public interface ItemService {
	Item saveItem(Item item);
	List<Item> getAllItems();
	Item getItemById(long id);
	Item updateItem(Item item , long id);
	void deleteItem(long id);
}
