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
		//teas.add(new Coffee()); // It does not accept the coffee list
		
		//prepareDrinks(teas); // The method prepareDrinks(List<Drink>) in the type Main is not applicable for the arguments (List<Tea>)
	}
	
	private static void prepareDrinks(List<Drink> drinks) {
		for (Drink b : drinks) {
			b.prepare();
		}
	}
}
