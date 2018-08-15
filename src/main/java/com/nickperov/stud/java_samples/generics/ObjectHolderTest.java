package com.nickperov.stud.java_samples.generics;

public class ObjectHolderTest {
	
	public static void main(String[] args) {
		
		ObjectHolder<A> objectHolder_A1 = new ObjectHolder<>();
		System.out.println("Is A1 objectHolder holder of A? " + objectHolder_A1.checkObjetType(A.class));
		
		ObjectHolder<A> objectHolder_A2 = new ObjectHolder<>(new A());
		System.out.println("Is A1 objectHolder holder of A? " + objectHolder_A2.checkObjetType(A.class));
		
		ObjectHolder<B> objectHolder_B1 = new ObjectHolder<>(new B());
		System.out.println("Is B1 objectHolder holder of B? " + objectHolder_B1.checkObjetType(B.class));
		
		ObjectHolder<B> objectHolder_B2 = new ObjectHolder<>(new C());
		System.out.println("Is B2 objectHolder holder of B? " + objectHolder_B2.checkObjetType(B.class));
		System.out.println("Is B2 objectHolder holder of C? " + objectHolder_B2.checkObjetType(C.class));
		
		ObjectHolder<C> objectHolder_C1 = new ObjectHolder<>(C.class);
		System.out.println("Is C1 objectHolder holder of C? " + objectHolder_C1.checkObjetType(C.class));
	}
}

class A {}

class B {}

class C extends B {}