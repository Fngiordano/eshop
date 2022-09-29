package com.example.demo.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Price")
public class Price {
	
	@Id
	private Long id;
	
	@Column(name = "itemPrice")
	private Integer itemPrice;

	@OneToMany(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;
	
	// Getters & Setters
	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	
	

}
