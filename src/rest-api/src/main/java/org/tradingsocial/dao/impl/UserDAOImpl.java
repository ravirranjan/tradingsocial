package org.tradingsocial.dao.impl;

import org.springframework.stereotype.Repository;
import org.tradingsocial.dao.AbstractDAO;
import org.tradingsocial.dao.UserDAO;
import org.tradingsocial.model.User;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	public User getUser(int id) {
		return (User) getSession().get(User.class, id);
	}

}
