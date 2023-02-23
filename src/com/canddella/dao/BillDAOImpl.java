package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Bill;
import com.canddella.entity.Booking;
import com.canddella.entity.Passenger;

public class BillDAOImpl implements BillDAO {
	@Override
	public List<Bill> findAll() {

		List<Bill> billList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bill";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int billId = resultSet.getInt(1);
				int passengerId = resultSet.getInt(2);
				int bookingId = resultSet.getInt(3);
				String paymentMode = resultSet.getString(4);
				String paymentDate = resultSet.getString(5);
				int amount = resultSet.getInt(6);
				
				Passenger passenger = new Passenger();
				passenger.setPassengerId(passengerId);
				Booking booking = new Booking();
				booking.setBookingId(bookingId);

				Bill bill = new Bill(billId,passenger,booking,paymentMode,paymentDate,amount);
				billList.add(bill);

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

		return billList;
	}
	@Override
	public int save(Bill bill) {
		String insertSQL = "insert into bill(passenger_id,booking_id,payment_mode,payment_date,amount)"+ " values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, bill.getPassenger().getPassengerId());
			preparedStatement.setInt(2, bill.getBooking().getBookingId());
			preparedStatement.setString(3, bill.getPaymentMode());
			preparedStatement.setString(4, bill.getPaymentDate());
			preparedStatement.setInt(5, bill.getAmount());
			
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
	public int update(Bill bill) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update bill set passenger_id=?,booking_id=?,payment_mode=?,payment_mode=?,amount=? where bill_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, bill.getPassenger().getPassengerId());
			preparedStatement.setInt(2, bill.getBooking().getBookingId());
			preparedStatement.setString(3, bill.getPaymentMode());
			preparedStatement.setString(4, bill.getPaymentDate());
			preparedStatement.setInt(5, bill.getAmount());
			preparedStatement.setInt(6, bill.getBillId());
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
	public int delete(Bill bill) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from bill where bill_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, bill.getBillId());
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
	public Bill billid(int id) {
		Bill bill = null;

		String searchSQL = "select * from bill where bill_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int billId = resultSet.getInt(1);
				int passengerId = resultSet.getInt(2);
				int bookingId = resultSet.getInt(3);
				String paymentMode = resultSet.getString(4);
				String paymentDate = resultSet.getString(5);
				int amount = resultSet.getInt(6);
				
				Passenger passenger = new Passenger();
				passenger.setPassengerId(passengerId);
				Booking booking = new Booking();
				booking.setBookingId(bookingId);
				
				bill = new Bill(billId, passenger, booking, paymentMode, paymentDate, amount);

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
		return bill;

	}

}
