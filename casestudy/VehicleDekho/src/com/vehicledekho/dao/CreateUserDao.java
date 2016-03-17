package com.vehicledekho.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vehicledekho.model.User;

public class CreateUserDao {
	public boolean SaveUserToDatabase(User user) {
		PreparedStatement preparedStatement = null;
		java.sql.Connection connection = Connection.getConnection();

		String writeQueryForUserTable = "insert into USERS(USERNAME,PASSWORD,FNAME,LNAME,PHONE,EMAIL) values (?,?,?,?,?,?);";
		try {
			// setting up prepared statement
			if (user != null) {
				preparedStatement = connection
						.prepareStatement(writeQueryForUserTable);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getfName());
				preparedStatement.setString(4, user.getlName());
				preparedStatement.setString(5, user.getPhone());
				preparedStatement.setString(6, user.getEmail());
				preparedStatement.executeUpdate();
			}
			// executing prepared statement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
			// Logger.log(e.printStackTrace());
		}
		return true;
	}
}
