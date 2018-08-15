package com.nickperov.stud.java_samples.basic;

public class PassByValue {
	
	public static void main(String[] args) {
		PassByValue pbv = new PassByValue();
		pbv.recursiveArrayCall(new char[] {'A'}, -15000); //5786
		//pbv.recursiveCall(-20400);
	}
	
	public void recursiveArrayCall(char[] array, int i) {
		if (array.length == i)
			return;
		
		recursiveArrayCall(array, ++i);
	}
	
	public void recursiveCall(int i) {
		if (0 == i)
			return;
		
		recursiveCall(++i);
	}
	
}
