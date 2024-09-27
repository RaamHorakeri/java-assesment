package com.scry.assignment.service;

import java.sql.SQLException;
import java.util.List;

import com.scry.assignment.model.Booking;
import com.scry.assignment.repository.BookingRepository;

public class BookingService {
	/**
	 * Get all bookings
	 * 
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public String getAllBookings(){
		List<Booking> bookings = new BookingRepository().queryDatabase("select * from BOOKING");
		return bookings.toString();
	}

}
