package com.scry.assignment.repository;

import com.scry.assignment.config.Config;
import com.scry.assignment.model.Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

	/**
	 * Query database
	 * 
	 * @param
	 * @return
	 */
	public List<Booking> queryDatabase(String sqlQueryString) {
		Connection conn = null;
		Statement stmt = null;
		List<Booking> bookings = new ArrayList<Booking>();

		try {
			// create connection
			Class.forName(Config.JDBC_DRIVER);
			conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);

			// query database and parse results
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQueryString);
			while (rs.next()) {
				Booking booking = new Booking(rs.getString("ID"), rs.getString("HALL_NAME"), rs.getString("CAPACITY"),
						rs.getTimestamp("START_TIME").toLocalDateTime(), rs.getTimestamp("END_TIME").toLocalDateTime());
				bookings.add(booking);
			}

			// close connections
			rs.close();
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
		return bookings;
	}

}
