package com.elasticcconcept.java.concurrent;

public class Reader implements Runnable {

	private Info info;
	private String name;
	
	public Reader(String name, Info info) {
		this.name = name;
		this.info = info;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				String text = info.getInfo();
				System.out.println(name + " => read: " + text);
				Thread.sleep(100);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
