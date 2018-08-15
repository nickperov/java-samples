package com.nickperov.stud.java_samples.concurrency;

import java.util.Random;

public class SynchronizationTest {

	public static void main(final String[] str) {
		final SynchronizationTest test = new SynchronizationTest();

		final Thread threadOne = new Thread(() -> {
			try {
				test.tryOne();
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		});

		final Thread threadTwo = new Thread(() -> {
			try {
				test.tryTwo();
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		});

		threadOne.start();
		threadTwo.start();
	}

	private synchronized void tryOne() throws InterruptedException {
		System.out.println("Try one");
		Thread.sleep(500 + new Random().nextInt(1000));
		System.out.println("Finish one");
	}


	private synchronized void tryTwo() throws InterruptedException {
		System.out.println("Try two");
		Thread.sleep(500 + new Random().nextInt(1000));
		System.out.println("Finish two");
	}


	private int getSleepTime() {
		return new Random().nextInt(1000);
	}
}
