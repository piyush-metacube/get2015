package com.vehicledekho.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/VEHICLE_DEKHO_DB";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	private static final String DRIVER ="com.mysql.jdbc.Driver";

	private static java.sql.Connection con = null;

	public static java.sql.Connection getConnection() {
		/* register driver */
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/* open connection */
		try {

			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
