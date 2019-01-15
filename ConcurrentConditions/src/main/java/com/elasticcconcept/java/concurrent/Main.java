package com.elasticcconcept.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	private static final int NUM_CAR = 5;

	public static void main(String[] args) {

		ExecutorService e = Executors.newFixedThreadPool(NUM_CAR + 1);

		TrafficLight trafficlight = new TrafficLight();
		e.execute(trafficlight);

		for (int i = 1; i <= NUM_CAR; i++) {
			Car car = new Car(i, trafficlight);
			e.execute(car);
		}

		e.shutdown();
	}
}

