package com.scry.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.scry.assignment.config.Config;
import com.scry.assignment.controller.Controller;

public class Application {

	public static void initializeDatabase() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// create connection
			Class.forName(Config.JDBC_DRIVER);
			conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);

			// create table and insert data
			stmt = conn.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS BOOKING");

			stmt.executeUpdate("CREATE TABLE BOOKING " + "(ID VARCHAR(20) PRIMARY KEY NOT NULL,"
					+ "  HALL_NAME VARCHAR(20) NOT NULL," + "  CAPACITY INT NOT NULL,"
					+ "  START_TIME TIMESTAMP NOT NULL," + "  END_TIME TIMESTAMP NOT NULL)");

			stmt.executeUpdate("INSERT INTO BOOKING (ID, HALL_NAME, CAPACITY, START_TIME, END_TIME) VALUES "
					+ "('2543541'," + "'A'," + "25," + "PARSEDATETIME('2021-06-27 15:00:00','YYYY-MM-DD HH:mm:ss'),"
					+ "PARSEDATETIME('2021-06-27 16:00:00','YYYY-MM-DD HH:mm:ss'))");

			stmt.executeUpdate("INSERT INTO BOOKING (ID, HALL_NAME, CAPACITY, START_TIME, END_TIME) VALUES "
					+ "('2546543'," + "'A'," + "50," + "PARSEDATETIME('2021-06-27 16:00:00','YYYY-MM-DD HH:mm:ss'),"
					+ "PARSEDATETIME('2021-06-27 17:00:00','YYYY-MM-DD HH:mm:ss'))");

			stmt.executeUpdate("INSERT INTO BOOKING (ID, HALL_NAME, CAPACITY, START_TIME, END_TIME) VALUES "
					+ "('2763549'," + "'B'," + "100," + "PARSEDATETIME('2021-06-27 16:00:00','YYYY-MM-DD HH:mm:ss'),"
					+ "PARSEDATETIME('2021-06-27 17:00:00','YYYY-MM-DD HH:mm:ss'))");

			stmt.executeUpdate("INSERT INTO BOOKING (ID, HALL_NAME, CAPACITY, START_TIME, END_TIME) VALUES "
					+ "('2543763'," + "'C'," + "200," + "PARSEDATETIME('2021-06-27 16:30:00','YYYY-MM-DD HH:mm:ss'),"
					+ "PARSEDATETIME('2021-06-27 17:30:00','YYYY-MM-DD HH:mm:ss'))");

			// close connection
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// initialize database
		initializeDatabase();
		
		// start server
		Controller controller = new Controller();
		controller.startServer();		
		System.out.println("Server started on port : " + Config.port);
	}

}
