package com.elasticcconcept.java.concurrent;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool; // Fork splits in two, Join adds

public class Main {

	public static void main(String[] args) {
		
		int[] array = new int[1000000]; // one thousand positions
		Arrays.fill(array, 1);
		
		SumArray task = new SumArray(array, 0, array.length - 1);
		
		ForkJoinPool fj = new ForkJoinPool();
		int soma = fj.invoke(task);
		
		System.out.println(soma);
	}
}
