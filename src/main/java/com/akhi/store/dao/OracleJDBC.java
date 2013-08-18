package com.akhi.store.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.akhi.store.general.User;

public class OracleJDBC {

	public static void main(String[] argv) {

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			/*
			 * connection = DriverManager.getConnection(
			 * "jdbc:oracle:thin:@localhost:1521:orcl", "system", "9868");
			 */

			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/adesh",
							"root", "9868");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			String id = "akhi";
			String password = "password";
			String sql = "SELECT USERID from Users where USERID = ?";

			System.out.println("Executing SQL " + sql);

			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				Statement stmt = connection.createStatement();
				ResultSet rs0 = stmt.executeQuery("SELECT * FROM Users");
				// ps.setString(2, password);
				// System.out.println("Executing result " + sql);
				ResultSet rs = ps.executeQuery();
				System.out.println(rs.next());
				System.out.println(rs0.next());
				// System.out.println(rs.first());
				// iterateRs(rs);
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
					}
				}
			}

		}
	}

	private static void iterateRs(ResultSet rs) throws SQLException {

		while (rs.next()) {
			System.out.println("iterate");
			System.out.println(rs.getString("USERID"));
		}

	}

}