package com.elasticcconcept.java.concurrent;

public class Car implements Runnable {

	private int id;
	private TrafficLight trafficlight;
	
	public Car(int id, TrafficLight trafficlight) {
		this.id = id;
		this.trafficlight = trafficlight;
	}
	
	@Override
	public void run() {
		while(true) {
			trafficlight.cross(id);
			try {
				Thread.sleep(1000 + (int)(Math.random() * 4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}