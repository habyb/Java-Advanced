package com.elasticcconcept.java.concurrent;

import java.util.concurrent.Callable;

public class Summation2 implements Callable<Integer> { // Callable returns values and allows you to throw exceptions

	private int n1;
	private int n2;
	
	public Summation2(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public Integer call() throws Exception {
		if (n1 < 0 || n2 < 0) {
			throw new IllegalArgumentException("Negative Number");
		}
		
		Thread.sleep(3000);
		return n1 + n2;
	}
}
