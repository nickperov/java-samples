package com.nickperov.stud.java_samples.collections.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class UnmodifiableCollectionsTest {
	
	//private static List<Integer> intList = new ArrayList<>();
	private static List<Integer> intList = new CopyOnWriteArrayList<>();
	private static int counter = 0;
	
	private static boolean threadFlag = true;
	
	private static Random rnd = new Random();
	
	public static void main(String[] args) {
		
		fillList(100000);
		
		List<Integer> viewList = Collections.unmodifiableList(intList);
		
		//List<Integer> copy = viewList.stream().filter(n -> n > 10000).collect(Collectors.toList());
		
		//Iterator<Integer> viewIterator = viewList.iterator();
		Iterator<Integer> modIterator = intList.iterator();
		System.out.println("+++");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// modify list in different thread
				/*while (threadFlag && modIterator.hasNext()) {
					Integer number = modIterator.next();
					if (number > 1000000) {
						modIterator.remove();
					}
				}*/
				
				while (threadFlag) {
					intList.add(rnd.nextInt());
				}
			}
		});
		
		t.start();
		
		try {
			
			/*while (viewIterator.hasNext()) {
				Integer number = viewIterator.next();
				if (number > 10000)
					counter++;
			}*/
			
			/*for (Integer number : viewList) {
				if (number > 10000)
					counter++;
			}*/
			
			viewList.forEach(number -> {
				if (number > 10000)
					counter++;
			});
			
			
			
		} catch (ConcurrentModificationException e) {
			System.out.println("Got Exception");
		} finally {
			threadFlag = false;
		}
		
		System.out.println("======>>>> Task Finished <<<<======");
		System.out.println(counter + " element counted");
	}
	
	private static void fillList(int size) {
		for (int i = 0; i < size; i++)
			intList.add(rnd.nextInt());
	}

}
