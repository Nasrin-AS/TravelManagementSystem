package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Driver;

public class DriverDAOImpl implements DriverDAO {

	@Override
	public List<Driver> findAll() {
		
		List<Driver> driverList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from driver";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int driverId = resultSet.getInt(1);
				String driverName = resultSet.getString(2);
				String driverPlace = resultSet.getString(3);
				String driverPhoneNumber = resultSet.getString(4);
				Driver driver = new Driver(driverId, driverName, driverPlace, driverPhoneNumber);
				driverList.add(driver);

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

		return driverList;
	}

	@Override
	public int save(Driver driver) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into driver(driver_id,driver_name,driver_place,driver_phoneno) values(?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, driver.getDriverId());
			preparedStatement.setString(2, driver.getDriverName());
			preparedStatement.setString(3, driver.getDriverPlace());
			preparedStatement.setString(4, driver.getDriverPhoneNumber());
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
	public int update(Driver driver) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update driver set driver_name=?,driver_place=?,driver_phoneno=? where driver_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, driver.getDriverName());
			preparedStatement.setString(2, driver.getDriverPlace());
			preparedStatement.setString(3, driver.getDriverPhoneNumber());
			preparedStatement.setInt(4, driver.getDriverId());
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
	public int delete(Driver driver) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from driver where driver_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, driver.getDriverId());
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
	public Driver driverid(int id) {
		Driver driver = null;

		String searchSQL = "select * from driver where driver_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int driverId = resultSet.getInt(1);
				String driverName = resultSet.getString(2);
				String driverPlace = resultSet.getString(3);
				String driverPhoneNumber = resultSet.getString(4);

				driver = new Driver(driverId, driverName, driverPlace, driverPhoneNumber);

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
		return driver;

	}

}
