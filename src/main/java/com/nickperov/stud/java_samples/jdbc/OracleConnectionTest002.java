package com.nickperov.stud.java_samples.jdbc;

import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class OracleConnectionTest002 extends AbstractOracleConnectionTest {

	@Override
	public void loadDriver() throws SQLException {
		
		System.out.println("Start oracle driver load");
		
		ods = new OracleDataSource();
		 
		System.out.println("Driver loaded successfully");
	}

}
