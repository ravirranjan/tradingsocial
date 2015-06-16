package org.tradingsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tradingsocial.application.UserApplication;
import org.tradingsocial.model.User;

@Controller
public class UserController {

	@Autowired
	private UserApplication application;

	@RequestMapping(value = "/users/{userid}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("userid") Integer userId) {
		return application.getUser(userId);
	}

	@RequestMapping(value = "/email/{email}/password/{password}", method = RequestMethod.GET)
	public @ResponseBody Integer login(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		Integer userId = application.login(email, password);

		return userId;
	}

	@RequestMapping(value = "forgotPassword/{forgotPassword}/email/{email}", method = RequestMethod.GET)
	public @ResponseBody Integer forgotPassword(@PathVariable("email") String email, @PathVariable("forgotPassword") boolean forgotPassword) {

		if (forgotPassword) {
			return application.forgotPassword(email);
		}
		
		return 0;
	}
}
