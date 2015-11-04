package com.vehicledekho.factories;

import com.vehicledekho.model.User;

public class UserFactory {
	public User makeUser(String username, String password, String fName,
			String lName, String phone, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setfName(fName);
		user.setlName(lName);
		user.setPhone(phone);
		user.setEmail(email);
		return user;
	}
}
