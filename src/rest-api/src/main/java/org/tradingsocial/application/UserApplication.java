package org.tradingsocial.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tradingsocial.model.User;
import org.tradingsocial.service.MailService;
import org.tradingsocial.service.UserService;

@Component
public class UserApplication {

	@Autowired
	private UserService userService;
	@Autowired
	private MailService mailService;

	public User getUser(int userId) {
		return userService.getUser(userId);
	}

	public User login(String email, String password) {
		User userId = userService.login(email, password);
		
		return userId;
	}
	
	public Integer forgotPassword(String email) {
		Map<String, String> root = new HashMap<String, String>();
		root.put("email", email);
		//This password will be generate with some formula in future
		root.put("password", "test@123");
		
		mailService.sendEmailAndBackup(email, root, "forgotPassword.ftl");
		
		return 1;
	}

}
