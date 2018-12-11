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
		
//		prepareDrinks2(coffees); // Not allowed
		prepareDrinks2(teas);
//		prepareDrinks2(drinks); // Pay attention! You can NOT coffee list
//		prepareDrinks2(coffees); // Pay attention! You can NOT coffee list
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
	
	private static void prepareDrinks2(List<? super Tea> drinks) {
//		drinks.add(new Tea()); // No problem
		
		// Pay attention! You can NOT coffee list
		for (Object obj : drinks) {
			Tea tea = (Tea) obj;
			tea.prepare();
		}
	}
	
	private static void prepareDrinks3(List<?> drinks) { // <? extends Object>
		
		// You can NOT add elements to the list (extends rule)
//		drinks.add("abc"); // Not secure
		
		for (Object obj : drinks) {
			Tea tea = (Tea) obj;
			tea.prepare();
		}
	}
}
