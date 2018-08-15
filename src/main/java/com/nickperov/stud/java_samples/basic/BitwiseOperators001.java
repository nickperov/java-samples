package com.nickperov.stud.java_samples.basic;

public class BitwiseOperators001 {
	
	public static void main(String[] args) {
		
		testBinaryXOR();
		testBooleanXOR();
		
	}
	
	private static void testBinaryXOR() {
		int i = 0b011;
		int k = 0b011;
		int result = i ^ k;
		
		System.out.println(result);
	}
	
	private static void testBooleanXOR() {
		boolean a = false;
		boolean b = true;
		
		boolean res = !a ^ b;
		
		System.out.println("Res: " + res);
	}
	
}
