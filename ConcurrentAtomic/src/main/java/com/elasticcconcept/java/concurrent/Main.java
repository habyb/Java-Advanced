package com.elasticcconcept.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		int numGenerator = 3;
		
		ExecutorService service = Executors.newFixedThreadPool(numGenerator);
		
		for (int i = 0; i < numGenerator; i++) {
			Generator g = new Generator();
			service.execute(g);
		}
		
		service.shutdown();
	}
}
