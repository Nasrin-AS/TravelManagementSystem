package com.canddella.service;

import java.util.List;

import com.canddella.entity.Booking;

public interface BookingService {
	List<Booking> findall();
	int save(Booking booking);
	int update(Booking booking);
	int delete(Booking booking);
	Booking bookingid(int id);
}
