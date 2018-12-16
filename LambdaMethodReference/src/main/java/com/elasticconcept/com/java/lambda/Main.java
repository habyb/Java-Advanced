package com.elasticconcept.com.java.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Alfred", "Joseph", "Richard", "Mary");
//		names.forEach(e -> System.out.println(e));
		// Same above
//		names.forEach(System.out::println);
		
//		names.replaceAll(e -> e.toUpperCase());
		// Same above
//		names.replaceAll(String::toUpperCase);
//		names.forEach(System.out::println);
		
		// Without reference to the method
		names.replaceAll(e -> Main.intercalate(e));
		
		// Reference to the method
		names.replaceAll(Main::intercalate);
		names.forEach(System.out::println);
	}
	
	private static String intercalate(String s) {
		char[] chars = s.toCharArray();
		
		boolean lowerCase = true;
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			if(lowerCase) {
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(Character.toUpperCase(c));
			}
			
			lowerCase = !lowerCase;
		}
		
		return sb.toString();
	}
}
