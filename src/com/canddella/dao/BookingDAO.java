package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Booking;

public interface BookingDAO {
	List<Booking> findAll();
	int save(Booking booking);
	int update(Booking booking);
	int delete(Booking booking);
	Booking bookingid(int id);
}
