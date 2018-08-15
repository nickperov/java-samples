package com.nickperov.stud.java_samples.collections.peformance;

import java.util.ArrayList;
import java.util.List;

public class ListCapacityTester {
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		
		Integer initCapacity = null;
		if (args.length > 0 && args[0] != null)
			initCapacity = Integer.parseInt(args[0]);
		else
			initCapacity = 16;
		
		runMap(new ArrayList<Integer>(initCapacity));
	}
	
	private static void runMap(List<Integer> list) {
		int counter = 0;
		while (true) {
			list.add(counter++);
			if(counter%1000000==0) System.out.println(""+counter);
		}
		
		
	}
}
