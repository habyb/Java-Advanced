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
		
		// You can NOT add elements to the list
//		drinks.add(new Tea()); // The method add(capture#1-of ? extends Drink) in the type List<capture#1-of ? extends Drink> is not applicable for the arguments (Tea)
		
		// You can remove elements to the list
//		drinks.remove(0);
		
		for (Drink b : drinks) {
			b.prepare();
		}
	}
}
