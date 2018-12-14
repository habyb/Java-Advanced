package com.elasticconcept.java.inner;

public class Main {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		calc.setValue1(10);
		calc.setValue2(20);
		int result = calc.somar();
		System.out.println(result);
	}
}
