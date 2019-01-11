package com.elasticcconcept.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		BankAccount account = new BankAccount();
		
		Customer c1 = new Customer(account);
		Customer c2 = new Customer(account);
		
		e.execute(c1);
		e.execute(c2);
		
		e.shutdown();
		
		while (!e.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				
			}
		}
		
		System.out.println(account.getBalance());
	}

}
