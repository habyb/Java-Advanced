package com.elasticcconcept.java.concurrent;

public class Generator implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int valor = Sequence.next();
			System.out.println(valor);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}