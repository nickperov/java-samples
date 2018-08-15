package com.nickperov.stud.java_samples.thread_executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
	
	public static void main(String[] args) throws Exception {
		// testCachedPool001();
		
		testThreadPool002(false);
		
		
		Thread.sleep(200000);
		//runCountSingleThread();
		
	}
	
	private static void runCountSingleThread() throws Exception {
		MathCount mc = new MathCount();
		System.out.println("Count result: " + mc.call());
	}
	
	private static class MathCount implements Callable<Double> {
		@Override
		public Double call() throws Exception {
		    Double a = 0d;
		    for (int i = 0; i < 1000000; i++)
		    	a = a + Math.tan(i);
		    
		    return a;
		}
		
	}
	
	
	private static void testCachedPool001() throws InterruptedException {
		//Thread.sleep(30_000);
		
		/*Executor fixThreadPool01 = Executors.newFixedThreadPool(10);
		Executor fixThreadPool02 = Executors.newFixedThreadPool(10);*/
		
		Executor fixThreadPool01 = Executors.newCachedThreadPool();
		Executor fixThreadPool02 = Executors.newCachedThreadPool();
		
		Runnable job = createJobWithSleep(50);
		
		for (int i = 0; i < 100; i++) {
			fixThreadPool01.execute(job);
			fixThreadPool02.execute(job);
			Thread.sleep(10);
		}
		
	//	Thread.sleep(1_000);
	}
	
	private static void testThreadPool002(boolean isFixed) {
		
		Executor threadPool;
		if (isFixed)
			threadPool = Executors.newFixedThreadPool(8);
		else
			threadPool = Executors.newCachedThreadPool();
		
		// Custom pool
		/*threadPool = new ThreadPoolExecutor(0, 50,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());*/
		
		threadPool = new ThreadPoolExecutor(5, 5,
				 0L, TimeUnit.MILLISECONDS,
                 new LinkedBlockingQueue<Runnable>(50));
		
		Runnable job = createJobWithSleep(100);
		
		for (int i = 0; i < 1000; i++)
			threadPool.execute(job);
		
	}
	
	private static Runnable createJobWithSleep(int millsec) {
		Runnable job = () -> {
			System.out.println("Add runnable job");
			try {Thread.sleep(millsec); } catch (InterruptedException e) {}
			System.out.println("Finish runnable job");
		};
		
		return job;
	}
}
