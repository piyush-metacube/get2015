package com.vehicledekho.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public boolean validateLogin(String username, String password) {
		boolean status = false;
		PreparedStatement preparedStatement = null;
		java.sql.Connection connection = Connection.getConnection();
		try {
			preparedStatement = connection
					.prepareStatement("select * from USERS where USERNAME=? and PASSWORD=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
