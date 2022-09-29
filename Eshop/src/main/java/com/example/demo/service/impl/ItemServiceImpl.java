package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Item;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	
	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item getItemById(long id) {
		return itemRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Item", "Id", id));
	}

	@Override
	public Item updateItem(Item item, long id) {
		
		// check item exist
		Item existingItem = itemRepository.findById(id).orElseThrow(() ->
								new ResourceNotFoundException("item", "id", id));
		
		existingItem.setItemName(item.getItemName());
		existingItem.setItemDescription(item.getItemDescription());
		existingItem.setCategory(item.getCategory());
		//save updated item  to db
		itemRepository.save(existingItem);
		return existingItem;
	}

	@Override
	public void deleteItem(long id) {
		itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item", "id", id));
		
		itemRepository.deleteById(id);
	}

	
	
}
