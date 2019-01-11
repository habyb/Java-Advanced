package com.elasticcconcept.java.concurrent;

public class Customer implements Runnable {

	private BankAccount account;
	
	public Customer(BankAccount account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				account.cashdeposit(100);
				Thread.sleep(200);
				account.withdraw(100);
			}
		} catch (InterruptedException e) {
			
		}
		
	}
	
}
