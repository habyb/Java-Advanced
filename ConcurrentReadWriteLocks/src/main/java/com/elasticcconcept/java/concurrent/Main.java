package com.elasticcconcept.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Info info = new Info();
		int numReaders = 5;
		int numWriters = 5;
		
		ExecutorService e = Executors.newFixedThreadPool(numReaders + numWriters);
		
		for (int i = 0; i < numReaders; i++) {
			Reader r = new Reader("Reader " + i, info);
			e.execute(r);
		}
		
		for (int i = 0; i < numWriters; i++) {
			Writer w = new Writer(info);
			e.execute(w);
		}
		
		e.shutdown();

	}

}
