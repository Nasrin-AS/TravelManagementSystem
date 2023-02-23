package com.canddella.service;

import java.util.List;

import com.canddella.dao.BookingDAOImpl;
import com.canddella.entity.Booking;

public class BookingServiceImpl implements BookingService {

	@Override
	public List<Booking> findall() {
		BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
		List<Booking> bookingList = bookingDAOImpl.findAll();
		return bookingList;
	}

	@Override
	public int save(Booking booking) {
		BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
		int row = bookingDAOImpl.save(booking);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

		return 0;
	}

	@Override
	public int update(Booking booking) {
		BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
		int row = bookingDAOImpl.update(booking);
		if (row != 0)
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("UPDATION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public int delete(Booking booking) {
		BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
		int row = bookingDAOImpl.delete(booking);
		if (row == 1)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!");
		return row;
	}

	@Override
	public Booking bookingid(int id) {
				BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
				Booking booking = bookingDAOImpl.bookingid(id);
				
				return booking;
			}

}
