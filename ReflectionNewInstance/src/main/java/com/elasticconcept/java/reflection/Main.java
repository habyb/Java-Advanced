package com.elasticconcept.java.reflection;

import java.io.File;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
//		Coffee drink = new Coffee();
//		Tea drink = new Tea();
//		drink.prepare();
		
		String className;
		try (Scanner scanner = new Scanner(new File("class_name.txt"))){
			className = scanner.nextLine();
		}
		
		Class<Drink> drinkClass = (Class<Drink>) Class.forName(className);
		Drink drink = drinkClass.getDeclaredConstructor().newInstance();
		drink.prepare();
	}
}
