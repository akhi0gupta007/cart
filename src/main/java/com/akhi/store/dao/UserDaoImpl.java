package com.akhi.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akhi.store.general.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(UserDaoImpl.class);

	@Override
	public User findById(Long id, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByExample(User exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User makePersistent(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeTransient(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByIdAndPassword(String id, String password) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>UserDaoImpl findByIdAndPassword"
				+ dataSource);
		User result = null;
		ResultSet rs;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * from Users where userid = '" + id
					+ "' and password = '" + password + "'";
			log.info("Executing SQL " + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs == null) {
				log.warn("Nothing found");
			} else {
				String empid;
				try {
					while (rs.next()) {
						id = rs.getString("USERID");
						password = rs.getString("PASSWORD");
						empid = rs.getString("EMP_ID");

						log.info("userid : " + id);
						result = new User(id, password, empid,
								rs.getString("FirstName"),
								rs.getString("LastName"),
								rs.getString("Address"), rs.getString("City"));
					}
					log.info("Result :::::::::::::" + result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
