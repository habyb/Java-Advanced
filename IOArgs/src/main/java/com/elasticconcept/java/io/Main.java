package com.elasticconcept.java.io;

public class Main {

	public static void main(String[] args) {
		System.out.println("Number of arguments: " + args.length);
		
		for (String arg : args) {
			System.out.println("=> " + arg);
		}
	}
}