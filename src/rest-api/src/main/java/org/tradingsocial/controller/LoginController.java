package org.tradingsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tradingsocial.application.UserApplication;

@Controller
public class LoginController {

	@Autowired
	private UserApplication application;

	@RequestMapping(value = "/email/{email}/password/{password}", method = RequestMethod.GET)
	public @ResponseBody Integer login(@PathVariable("email") String email, @PathVariable("password") String password) {
		Integer userId =  application.login(email, password);
		
		return userId;
	}
	
}
