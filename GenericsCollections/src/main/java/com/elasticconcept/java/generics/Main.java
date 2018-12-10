package com.elasticconcept.java.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
//		List list = new ArrayList(); // Eclipse Warning - ArrayList is a raw Type
//		
//		list.add("abc");
//		list.add("def");
//		list.add("ghi");
//		list.add(10); // Execution Error - java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java
//		list.add(new Date()); // Execution Error - java.lang.ClassCastException: class java.util.Date cannot be cast to class java.
//		
////		for (String s : list) { // Type mismatch: cannot convert from element type Object to String
////			
////		}
//		
//		for (Object obj : list) { 
//			String s = (String) obj;
//			System.out.println(s);
//		}
		
		
		List<String> list = new ArrayList<>();
		
		list.add("abc");
		list.add("def");
		list.add("ghi");
//		list.add(10); // Compile Time Error
//		list.add(new Date()); // Compile Time Error
		
//		for (String s : list) { // Type mismatch: cannot convert from element type Object to String
//			
//		}
		
		for (String s : list) { 
			System.out.println(s);
		}
	}
}
