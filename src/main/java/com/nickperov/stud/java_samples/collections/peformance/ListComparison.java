package com.nickperov.stud.java_samples.collections.peformance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {

	private static final int	MAX_SIZE		= 1000;
	private static final int	MAX_ITERATIONS	= 10000;
	private static final float	STEP_SIZE		= 2f;
	private static final float	STEP_ITERATIONS	= 5;
	private static final int	TESTS_COUNT		= 100;

	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> arrayList;
		LinkedList<String> linkedList;
		for (float size = 1; size < MAX_SIZE; size *= STEP_SIZE) {
			for (float iterations = 1; iterations < MAX_ITERATIONS; iterations *= STEP_ITERATIONS) {
				double sum = 0;
				for (int k = 0; k < TESTS_COUNT; k++) {
					arrayList = new ArrayList<>();
					linkedList = new LinkedList<>();
					fillList(arrayList, (int) size);
					fillList(linkedList, (int) size);
					sum += Math.log10(calculateRatio(arrayList, linkedList, (int) iterations));
				}
				double logRatio = sum / TESTS_COUNT;
				System.out.println(String.format("%07d\t%07d\t%07.2f\t%s", (int) size, (int) iterations, logRatio, logRatio > 0 ? "Linked" : "Array"));
			}
			System.out.println();
		}
	}

	static void fillList(List<String> list, int size) {
		for (int i = 0; i < size; i++) {
			list.add("0");
		}
	}

	static double calculateRatio(ArrayList<String> arrayList, LinkedList<String> linkedList, int iterations) {
		long l1 = calculateAL(arrayList, iterations);
		long l2 = calculateLL(linkedList, iterations);
		if (l1 == 0 || l2 == 0)
			throw new java.lang.IllegalStateException();
		return (double) l1 / (double) l2;
	}

	static long calculateAL(ArrayList<String> list, int m) {
		long t = System.nanoTime();
		for (int i = 0; i < m; i++) {
			list.add(list.size() / 2, "0");
		}
		return System.nanoTime() - t;
	}

	static long calculateLL(LinkedList<String> list, int m) {
		long t = System.nanoTime();
		for (int i = 0; i < m; i++) {
			list.add(list.size() / 2, "0");
		}
		return System.nanoTime() - t;
	}
}