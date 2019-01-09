package com.elasticconcept.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	private static List<Product> products;
	
	static {
		products = new ArrayList<>();
		products.add(new Product(1, "Potato", 3.5));
		products.add(new Product(2, "Tomato", 4.3));
		products.add(new Product(3, "Onion", 2.9));
		products.add(new Product(4, "Carrot", 1.8));
		products.add(new Product(5, "Pod", 3.2));
	}
	
	public static void main(String[] args) {
//		execute1();
//		execute2();
		execute3();
	}

	private static void execute1() {
		// Sort products by price
		// Convert prices into dollars
		// Display the product data on the screen
		
		double quotation = 4; 
		
		products.stream()
			.sorted((e1, e2) -> Double.valueOf(e1.getPrice()).compareTo(e2.getPrice()))
			.map(p -> new Product(p.getId(), p.getName(), p.getPrice() / quotation))
			.forEach(p -> System.out.println(p.getName() + " -> " + p.getPrice()));
	}
	
	private static void execute2() {
		// Create a map where the key is the ID and the value is the product's name
		
		Map<Integer, String> map = products.stream()
			.collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
		
		System.out.println(map);
	}
	
	private static void execute3() {
		// Create a text representation of the products
		
		String str = products.stream()
			.map(p -> String.format("%d:%s:%.2f", p.getId(), p.getName(), p.getPrice()))
			.collect(Collectors.joining(";"));
		
		System.out.println(str);
	}
}
