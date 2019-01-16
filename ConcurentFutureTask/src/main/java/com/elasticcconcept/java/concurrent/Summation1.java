package com.elasticcconcept.java.concurrent;

public class Summation1 implements Runnable {

	private int n1;
	private int n2;
	private int result;
	private Exception exception;
	private volatile boolean running; // volatile: No Cache (lock is not necessary)

	public Summation1(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
		running = true;
	}

	@Override
	public void run() { // Does not allow throwing an exception out
		try {
			if (n1 < 0 || n2 < 0) {
				throw new Exception("Negative Number");
			}

			Thread.sleep(3000);
			result = n1 + n2;
		
		} catch (Exception e) {
			this.exception = e;
		} finally {
			running = false;
		}
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public int getResult() {
		return result;
	}
	
	public Exception getException() {
		return exception;
	}
}
