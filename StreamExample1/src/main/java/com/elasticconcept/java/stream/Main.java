package com.elasticconcept.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	private static List<String> items = Arrays.asList("computer", "paper", "pen", "board", "rubber", "curtain", "drawer");
	
	public static void main(String[] args) {
//		execute1();
//		execute2();
		execute3();
	}

	private static void execute1() {
		// 1. Order
		// 2. Keep only the first 3 elements
		// 3. Show result on screen
				
		items.stream()
			.sorted()
			.limit(3)
			.forEach(System.out::println);
	}
	
	private static void execute2() {
		// 1. Filter only elements with the letter e
		// 2. Create a new list with these elements
		
		 List<String> filteredItems = items.stream()
		 	.filter(e -> e.contains("e"))
		 	.collect(Collectors.toList());
		 
		 System.out.println(filteredItems);
	}
	
	private static void execute3() {
		// 1. Sum the amount of letters of all elements
		// 2. Return sum
		
		int count = items.stream()
			.collect(Collectors.summingInt(e -> e.length()));
		
		System.out.println(count);
	}
}
