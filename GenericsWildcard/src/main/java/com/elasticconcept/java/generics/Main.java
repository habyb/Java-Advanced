package com.elasticconcept.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Drink> drinks = new ArrayList<Drink>();
		
		drinks.add(new Coffee());
		drinks.add(new Tea());
		
		prepareDrinks(drinks);
		
		List<Tea> teas = new ArrayList<Tea>();
		teas.add(new Tea());
		prepareDrinks(teas);
		
		List<Coffee> coffees = new ArrayList<Coffee>();
		coffees.add(new Coffee());
		prepareDrinks(coffees);
	}
	
	private static void prepareDrinks(List<? extends Drink> drinks) {
		for (Drink b : drinks) {
			b.prepare();
		}
	}
}
