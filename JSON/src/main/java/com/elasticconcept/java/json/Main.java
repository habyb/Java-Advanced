package com.elasticconcept.java.json;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) throws Exception {
		ShoppingCart cart = new ShoppingCart();
		
		cart.add(new Product(1, "Rice"));
		cart.add(new Product(2, "Bean"));
		cart.add(new Product(3, "Coffee"));
		cart.print();
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(cart);
		System.out.println(jsonStr);
		
		ShoppingCart cart2 = gson.fromJson(jsonStr, ShoppingCart.class);
		cart2.print();
	}
}
