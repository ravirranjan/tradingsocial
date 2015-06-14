package org.tradingsocial.dao;

import java.util.List;

import org.tradingsocial.model.User;

public interface UserDAO {
	
	User getUser(int id);
	void saveOrUpdate(User user);
	void delete(int id);
	User getUserByEmail(String emailAddress);
	User loginAsUser(String emailAddress, String password);
	List<User> getAllUser();
}
