package com.elasticconcept.java.inner;

// Outer Class
public class Calculator {

	private int value1;
	private int value2;
	private int result;
	
	// Inner Class
	private class Sum {
		public void execute() {
			result = value1 + value2;
		}
	}
	
	public int getValue1() {
		return value1;
	}
	
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	
	public int getValue2() {
		return value2;
	}
	
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	
	public int somar() {
//		Calculator.Sum s = new Calculator.Sum();
		Sum s = new Sum();
		s.execute();
		return result;
	}
}
