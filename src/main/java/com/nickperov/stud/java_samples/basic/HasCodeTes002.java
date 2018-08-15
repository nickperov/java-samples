package com.nickperov.stud.java_samples.basic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
public class HasCodeTes002 { 
    static int count = 0; 
 
    public static void main(String[] args) { 
 
        Map employees = new HashMap(); 
 
        employees.put(new String("Joe"), new Integer("1")); 
        employees.put(new String("Chandler"), new Integer("2")); 
        employees.put(new String("Chandler"), new Integer("5")); 
        employees.put(new String("Ross"), new Integer("3")); 
        
        int c = 0x081;
         
        Iterator iterator = employees.keySet().iterator(); 
 
        while (iterator. hasNext()) { 
            System.out.println(iterator.next()); 
        } 
 
        System.out.println(count); 
    } 
}