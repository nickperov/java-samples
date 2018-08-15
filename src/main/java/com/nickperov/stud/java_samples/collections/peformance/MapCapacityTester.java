package com.nickperov.stud.java_samples.collections.peformance;

import java.util.HashMap;
import java.util.Map;

public class MapCapacityTester {
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		
		Integer initCapacity = null;
		if (args.length > 0 && args[0] != null)
			initCapacity = Integer.parseInt(args[0]);
		else
			initCapacity = 16;
		
		runMap(new HashMap<Object, String>(initCapacity));
	}
	
	private static void runMap(Map<Object, String> map) {
		long counter = 0;
		while (true) {
			map.put(counter++, "");
			if(counter%1000000==0) System.out.println(""+counter);
		}
		
		
	}

}
