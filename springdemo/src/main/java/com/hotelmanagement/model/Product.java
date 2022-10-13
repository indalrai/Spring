package com.hotelmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long pid;
	
	@Column(name="product_name" ,nullable = false)
	String productName;
	
	@Column(name="product_price" ,nullable = false)
	long productPrice;
	
	@Column(name="number_of_items" ,nullable = false)
	long numberOfItems;
	
	

}
