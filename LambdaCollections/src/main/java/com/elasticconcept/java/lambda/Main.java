package com.elasticconcept.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 5, 2, 1, 0, 3);
		
		// No Lambda
//		for (Integer i : list) {
//			System.out.println(i);
//		}
		
		// LAMBDA
		// ------
		list.forEach(e -> System.out.println(e));
		
		// Sort ASC
//		list.sort((x, y) -> x.compareTo(y));
//		list.forEach(e -> System.out.println(e));
				
		// Sort DESC
//		list.sort((x, y) -> -x.compareTo(y));
//		list.forEach(e -> System.out.println(e));
		
		// Multiply each element by 2
//		list.replaceAll(e -> e * 2);
//		list.forEach(e -> System.out.println(e));
		
		System.out.println();
		
		// Remove odd number
		List<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(2);
		list2.add(1);
		list2.add(0);
		list2.add(3);
		list2.removeIf(e -> e % 2 != 0);
		list2.forEach(e -> System.out.println(e));
	}

}
