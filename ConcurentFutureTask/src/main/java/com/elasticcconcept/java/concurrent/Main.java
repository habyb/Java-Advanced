package com.elasticcconcept.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) throws Exception {
		
//		Summation1 summation1 = new Summation1(20, 10);
//		
//		ExecutorService service = Executors.newSingleThreadExecutor();
//		
//		service.execute(summation1);
//		
//		while (summation1.isRunning()) {
//			Thread.sleep(1000);
//			System.out.println("Waiting...");
//		}
//		
//		if (summation1.getException() == null) {
//			int result = summation1.getResult();
//			System.out.println(result);
//		} else {
//			System.out.println("ERROR: " + summation1.getException());
//		}
//		
//		service.shutdown();
		
		
		Summation2 summation2 = new Summation2(20, 10);
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		FutureTask<Integer> task = new FutureTask<>(summation2);
		service.execute(task);
		
		while (!task.isDone()) {
			Thread.sleep(1000);
			System.out.println("Waiting...");
		}
		
		try {
			int result = task.get();
			System.out.println(result);
		
		} catch (ExecutionException e) {
			Throwable innerEx = e.getCause();
			System.out.println("Error: " + innerEx);
		}
		
		service.shutdown();
	}
}