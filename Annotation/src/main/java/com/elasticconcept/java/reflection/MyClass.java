package com.elasticconcept.java.reflection;

public class MyClass {

	@Execute("A")
	public static void m1(String param) {
		System.out.println("m1(): " + param);
	}
	
	@Execute("B")
	public static void m2(String param) {
		System.out.println("m2(): " + param);
	}
	
	public static void m3(String param) {
		System.out.println("m3(): " + param);
	}
	
}
