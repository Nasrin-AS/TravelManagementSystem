package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Bus;
import com.canddella.entity.BusRoute;
import com.canddella.entity.Driver;
import com.canddella.entity.Owner;

public class BusDAOImpl implements BusDAO {
	@Override
	public List<Bus> findAll() {

		List<Bus> busList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bus";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int busId = resultSet.getInt(1);
				int driverId = resultSet.getInt(2);
				int ownerId = resultSet.getInt(3);
				String busName = resultSet.getString(4);
				
				Driver driver = new Driver();
				driver.setDriverId(driverId);
				Owner owner = new Owner();
				owner.setOwnerId(ownerId);

				Bus bus = new Bus(busId,driver,owner,busName);
				busList.add(bus);

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

		return busList;
	}
	@Override
	public int save(Bus bus) {
		String insertSQL = "insert into bus(driver_id,owner_id,bus_name)"+ " values(?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, bus.getDriver().getDriverId());
			preparedStatement.setInt(2, bus.getOwner().getOwnerId());
			preparedStatement.setString(3, bus.getBusName());
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
	public int update(Bus bus) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update bus set driver_id=?,owner_id=?,bus_name=? where bus_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, bus.getDriver().getDriverId());
			preparedStatement.setInt(2, bus.getOwner().getOwnerId());
			preparedStatement.setString(3, bus.getBusName());
			preparedStatement.setInt(4, bus.getBusId());
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
	public int delete(Bus bus) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from bus where bus_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, bus.getBusId());
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
	public Bus busid(int id) {
		Bus bus = null;

		String searchSQL = "select * from bus where bus_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int busId = resultSet.getInt(1);
				int driverId = resultSet.getInt(2);
				int ownerId = resultSet.getInt(3);
				String busName = resultSet.getString(4);
				Driver driver = new Driver();
				driver.setDriverId(driverId);
				Owner owner = new Owner();
				owner.setOwnerId(ownerId);
				
				bus = new Bus(busId, driver, owner, busName);

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
		return bus;

	}

}
