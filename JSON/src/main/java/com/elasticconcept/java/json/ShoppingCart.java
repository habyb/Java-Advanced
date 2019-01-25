package com.elasticconcept.java.json;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Product> products = new ArrayList<>();
	
	public void add(Product p) {
		products.add(p);
	}
	
	public void print() {
		products.forEach(System.out::println);
	}
}