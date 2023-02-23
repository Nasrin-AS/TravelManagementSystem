package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Passenger;

public class PassengerDAOImpl implements PassengerDAO {

	@Override
	public List<Passenger> findAll() {
		List<Passenger> passengerList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from passenger";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int passengerId = resultSet.getInt(1);
				String passengerName = resultSet.getString(2);
				String passengerAddress = resultSet.getString(3);
				String passengerPhoneNumber = resultSet.getString(4);
				String passengerMailId = resultSet.getString(5);
				Passenger passenger = new Passenger(passengerId, passengerName, passengerAddress, passengerPhoneNumber,
						passengerMailId);
				passengerList.add(passenger);

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

		return passengerList;
	}

	@Override
	public int save(Passenger passenger) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into passenger(passenger_id,passenger_name,passenger_address,passenger_phoneno,passenger_mailid) values(?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, passenger.getPassengerId());
			preparedStatement.setString(2, passenger.getPassengerName());
			preparedStatement.setString(3, passenger.getPassengerAddress());
			preparedStatement.setString(4, passenger.getPassengerPhoneNumber());
			preparedStatement.setString(5, passenger.getPassengerMailId());
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
	public int update(Passenger passenger) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update passenger set passenger_name=?,passenger_address=?,passenger_phoneno=?,passenger_mailid=? where passenger_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, passenger.getPassengerName());
			preparedStatement.setString(2, passenger.getPassengerAddress());
			preparedStatement.setString(3, passenger.getPassengerPhoneNumber());
			preparedStatement.setString(4, passenger.getPassengerMailId());
			preparedStatement.setInt(5, passenger.getPassengerId());
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
	public int delete(Passenger passenger) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from passenger where passenger_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, passenger.getPassengerId());
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
	public Passenger passengerid(int id) {

		Passenger passenger = null;

		String searchSQL = "select * from passenger where passenger_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int passengerId = resultSet.getInt(1);
				String passengerName = resultSet.getString(2);
				String passengerAddress = resultSet.getString(3);
				String passengerPhoneNumber = resultSet.getString(4);
				String passengerMailId = resultSet.getString(5);
				

				passenger = new Passenger(passengerId, passengerName, passengerAddress, passengerPhoneNumber,passengerMailId);

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
		return passenger;

	}

}
