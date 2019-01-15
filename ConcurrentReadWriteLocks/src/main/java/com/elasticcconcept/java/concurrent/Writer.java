package com.elasticcconcept.java.concurrent;

public class Writer implements Runnable {

	private Info info;

	public Writer(Info info) {
		this.info = info;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			info.setInfo();
		}
	}
}
