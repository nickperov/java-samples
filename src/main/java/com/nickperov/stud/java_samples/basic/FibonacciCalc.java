package com.nickperov.stud.java_samples.basic;


public class FibonacciCalc {

	public static void main(String[] args) {
		
		// 1, 1, 2, 3, 5, 8, 13
		
		System.out.println("Fibonacci recursion: " + fib(10));
		
		System.out.println("Fibonacci tail recursion: " + fibWithTailRec(10));
	}
	
	// Simple recursion
	public static int fib(int n) {
		if (n > 1) return fib(n - 1) + fib (n - 2);
		else return n;
	}
	
	// Tail recursion
	public static int fibWithTailRec(int n) {
		if (n > 1) return fibIter(1, 1, n - 2);
		else return n; 
	}
	
	public static int fibIter(int prev, int current, int n) {
		if (n == 0) return current;
		else return fibIter(current, current + prev, n - 1);
	}
}