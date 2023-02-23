package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Booking;
import com.canddella.entity.Bus;
import com.canddella.entity.BusRoute;
import com.canddella.entity.Passenger;

public class BookingDAOImpl implements BookingDAO {

	@Override
	public List<Booking> findAll() {
		List<Booking> bookingList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from booking";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int bookingId = resultSet.getInt(1);
				int passengerId = resultSet.getInt(2);
				int busId = resultSet.getInt(3);
				int routeId = resultSet.getInt(4);
				String bookingDate = resultSet.getString(5);
				
				Passenger passenger = new Passenger();
				passenger.setPassengerId(passengerId);
				Bus bus = new Bus();
				bus.setBusId(busId);
				BusRoute busRoute = new BusRoute();
				busRoute.setRouteId(routeId);

				Booking booking = new Booking(bookingId,passenger,bus,busRoute,bookingDate);
				bookingList.add(booking);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return bookingList;
	}

	@Override
	public int save(Booking booking) {
		String insertSQL = "insert into booking(passenger_id,bus_id,route_id,booking_date)"+ " values(?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, booking.getPassenger().getPassengerId());
			preparedStatement.setInt(2, booking.getBus().getBusId());
			preparedStatement.setInt(3, booking.getBusRoute().getRouteId());
			preparedStatement.setString(4, booking.getBookingDate());
			
			int row = preparedStatement.executeUpdate();
			return row;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int update(Booking booking) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update booking set passenger_id=?,bus_id=?,route_id=?,booking_date=? where booking_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, booking.getPassenger().getPassengerId());
			preparedStatement.setInt(2, booking.getBus().getBusId());
			preparedStatement.setInt(3, booking.getBusRoute().getRouteId());
			preparedStatement.setString(4, booking.getBookingDate());
			preparedStatement.setInt(5, booking.getBookingId());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(Booking booking) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from booking where booking_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, booking.getBookingId());
			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		return 0;
	}
	@Override
	public Booking bookingid(int id) {
		Booking booking = null;
		String searchSQL = "select * from booking where booking_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int bookingId = resultSet.getInt(1);
				int passengerId = resultSet.getInt(2);
				int busId = resultSet.getInt(3);
				int routeId = resultSet.getInt(4);
				String bookingDate = resultSet.getString(5);
				
				Passenger passenger = new Passenger();
				passenger.setPassengerId(passengerId);
				
				Bus bus = new Bus();
				bus.setBusId(busId);
				
				BusRoute busRoute = new BusRoute();
				busRoute.setRouteId(routeId);
				
				
				 booking = new Booking(bookingId, passenger, bus, busRoute, bookingDate);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return booking;

		
	}
	
}
