package com.elasticcconcept.java.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight implements Runnable {
	private boolean open = false;
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	@Override
	public void run() {
		while (true) {
			lock.lock();
			try {
				open = !open;
				System.out.println("Traffic Light Open: " + open);
				
				if (open) {
					condition.signalAll(); // Wake up All Threads
				}
			} finally {
				lock.unlock();
			}
			
			try {
				Thread.sleep(1000 + (int) (Math.random() * 4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void cross(int id) {
		lock.lock();
		try {
			while (!open) {
				System.out.println("[Car " + id + "] waiting");
				
				condition.await();
			}
	
			System.out.println("[Car " + id + "] went through");
		} catch (InterruptedException e) {
			
		} finally {
			lock.unlock();
		}
	}
}

