package com.elasticconcept.java.concurrent;

public class Task implements Runnable {
	
	private int id;

	public Task(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Task " + id + " is starting");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Task " + id + " is stopping");
	}
}
