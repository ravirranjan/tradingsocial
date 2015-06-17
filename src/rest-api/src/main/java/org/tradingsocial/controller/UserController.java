package org.tradingsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tradingsocial.application.UserApplication;
import org.tradingsocial.model.User;

@Controller
public class UserController {

	@Autowired
	private UserApplication application;

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("userid") Integer userId) {
		return application.getUser(userId);
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody User user) {
		return application.login(user.getEmailAddress(), user.getPassword());
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public void forgotPassword(@RequestBody User user) {
		application.forgotPassword(user.getEmailAddress());
	}
}
