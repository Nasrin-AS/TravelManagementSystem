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

public class BusRouteDAOImpl implements BusRouteDAO {
	@Override
	public List<BusRoute> findAll() {

		List<BusRoute> busRouteList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from bus_route";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int routeId = resultSet.getInt(1);
				int busId = resultSet.getInt(2);
				String startingPoint = resultSet.getString(3);
				String destination = resultSet.getString(4);
				String startingTime = resultSet.getString(5);
				String destinationTime = resultSet.getString(6);
				
				Bus bus = new Bus();
				bus.setBusId(busId);

				BusRoute busRoute = new BusRoute(routeId,bus,startingPoint,destination,startingTime,destinationTime);
				busRouteList.add(busRoute);

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

		return busRouteList;
	}
	@Override
	public int save(BusRoute busRoute) {

		String insertSQL = "insert into bus_route(starting_point,destination,starting_time,destination_time,bus_id)"
				+ " values(?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, busRoute.getStartingPoint());
			preparedStatement.setString(2, busRoute.getDestination());
			preparedStatement.setString(3, busRoute.getStartingTime());
			preparedStatement.setString(4, busRoute.getDestinationTime());
			preparedStatement.setInt(5, busRoute.getBus().getBusId());
			int row = preparedStatement.executeUpdate();
			return row;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int update(BusRoute busRoute) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update bus_route set bus_id=?,starting_point=?,destination=?,starting_time=?,destination_time=? where route_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setInt(1, busRoute.getBus().getBusId());
			preparedStatement.setString(2, busRoute.getStartingPoint());
			preparedStatement.setString(3, busRoute.getDestination());
			preparedStatement.setString(4, busRoute.getStartingTime());
			preparedStatement.setString(5, busRoute.getDestinationTime());
			preparedStatement.setInt(6, busRoute.getRouteId());
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
	public int delete(BusRoute busRoute) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from bus_route where route_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, busRoute.getRouteId());
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
	public BusRoute busRouteid(int id) {
		BusRoute busRoute = null;

		String searchSQL = "select * from bus_route where route_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int routeId = resultSet.getInt(1);
				int busId = resultSet.getInt(2);
				String startingPoint = resultSet.getString(3);
				String destination = resultSet.getString(4);
				String startingTime = resultSet.getString(5);
				String destinationTime = resultSet.getString(6);
				Bus bus = new Bus();
				bus.setBusId(busId);
				
				
				busRoute = new BusRoute(routeId, bus, startingPoint, destination, startingTime, destinationTime);

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
		return busRoute;

	}
}
