package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Owner;


public class OwnerDAOImpl implements OwnerDAO {

	@Override
	public List<Owner> findAll() {
		List<Owner> ownerList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from owner";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int ownerId = resultSet.getInt(1);
				String ownerName = resultSet.getString(2);
				String ownerAddress = resultSet.getString(3);
				String ownerPhoneNumber = resultSet.getString(4);
				Owner owner = new Owner(ownerId, ownerName, ownerAddress, ownerPhoneNumber);
				ownerList.add(owner);

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

		return ownerList;

	}

	@Override
	public int save(Owner owner) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into owner(owner_id,owner_name,owner_address,owner_phoneno) values(?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1, owner.getOwnerId());
			preparedStatement.setString(2, owner.getOwnerName());
			preparedStatement.setString(3, owner.getOwnerAddress());
			preparedStatement.setString(4, owner.getOwnerPhoneNumber());
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
	public int update(Owner owner) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update owner set owner_name=?,owner_Address=?,driver_phoneno=? where driver_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, owner.getOwnerName());
			preparedStatement.setString(2, owner.getOwnerAddress());
			preparedStatement.setString(3, owner.getOwnerPhoneNumber());
			preparedStatement.setInt(4, owner.getOwnerId());
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
	public int delete(Owner owner) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String DELETE_SQL = "delete from owner where owner_id=?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, owner.getOwnerId());
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

	public Owner ownerid(int id) {

		Owner owner = null;

		String searchSQL = "select * from owner where owner_id=" + id;
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(searchSQL);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int ownerId = resultSet.getInt(1);
				String ownerName = resultSet.getString(2);
				String ownerAddress = resultSet.getString(3);
				String ownerPhoneNumber = resultSet.getString(4);

				owner = new Owner(ownerId, ownerName, ownerAddress, ownerPhoneNumber);

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
		return owner;

	}

}
