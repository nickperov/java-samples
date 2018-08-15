package com.nickperov.stud.java_samples.generics;

import java.util.ArrayList;
import java.util.List;

public class ObjectHolder<T> {
	
	private List<T> objectList;
	private Class<? extends Object> objectType;
	
	
	// Default constructor
	public ObjectHolder() {
		objectList = new ArrayList<>(); // Create Array List of Object
	}
	
	public ObjectHolder(T t) {
		objectList = new ArrayList<>(); // Create Array List of Object
		objectType = t.getClass();
	}
	
	public ObjectHolder(Class<T> clazz) {
		objectList = new ArrayList<>(); // Create Array List of Object
		objectType = clazz;
	}
	
	public List<T> getObjectList() {
		return objectList;
	}
	
	public T getObject(int i) {
		return objectList.get(i);
	}
	
	public boolean checkObjetType(Class<?> clazz) {
		return clazz.equals(objectType);
	}
}
