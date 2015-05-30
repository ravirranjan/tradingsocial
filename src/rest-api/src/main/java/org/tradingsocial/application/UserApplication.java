package org.tradingsocial.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tradingsocial.model.User;
import org.tradingsocial.service.UserService;

@Component
public class UserApplication {

	@Autowired
	private UserService userService;

	public User getUser(int userId) {
		return userService.getUser(userId);
	}

}
