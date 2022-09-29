package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table (name = "Items")


//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//		name = "CATEGORY_NAME",
//		discriminatorType = DiscriminatorType.STRING
//		)
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_description")
	private String itemDescription;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price")
	private Price price;


	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	
	
}
