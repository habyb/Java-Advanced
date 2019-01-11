package com.elasticcconcept.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private ReentrantLock lock = new ReentrantLock();
	
	private double balance;
	
	public void withdraw(double value) {
		lock.lock();
		try {
			this.balance -= value;
		} finally {
			lock.unlock();
		}
	}
	
	public void cashdeposit(double value) {
		lock.lock();
		try {
			this.balance += value;
		} finally {
			lock.unlock();
		}
	}

	public double getBalance() {
		return balance;
	}
}
