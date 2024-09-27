package com.scry.assignment.config;

public class Config {
	private Config() {
	};

	// server
	public static final int port = 8085;

	// JDBC driver name and database URL 
	public static final String JDBC_DRIVER = "org.h2.Driver";
	public static final String DB_URL = "jdbc:h2:file:./database/booking";
	public static final String DB_USER = "scry";
	public static final String DB_PASSWORD = "scry";
	
}
