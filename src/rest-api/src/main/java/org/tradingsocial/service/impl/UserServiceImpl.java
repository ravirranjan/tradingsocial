package org.tradingsocial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tradingsocial.dao.UserDAO;
import org.tradingsocial.model.User;
import org.tradingsocial.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

}
