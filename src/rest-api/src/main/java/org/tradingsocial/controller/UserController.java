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
	@ResponseBody
	public User getUser(@PathVariable("userid") Integer userId) {
		return application.getUser(userId);
	}

}