package com.elasticconcept.java.inner;

public class Main {

	public static void main(String[] args) {
		
		Drink d1 = new Tea();
		
		// Inner Class Anonymous
		Drink d2 = new Drink() {
			@Override
			public void prepare() {
				System.out.println("Preparing unidentified beverage");
			}
		};
		
		d1.prepare();
		d2.prepare();
	}
}
