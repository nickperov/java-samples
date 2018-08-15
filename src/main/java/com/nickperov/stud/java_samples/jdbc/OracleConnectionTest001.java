package com.nickperov.stud.java_samples.jdbc;


public class OracleConnectionTest001 extends AbstractOracleConnectionTest {
	
	
	@Override
	public void loadDriver() throws ClassNotFoundException {
		
		System.out.println("Start oracle driver load");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		System.out.println("Driver loaded successfully");
	}
}
