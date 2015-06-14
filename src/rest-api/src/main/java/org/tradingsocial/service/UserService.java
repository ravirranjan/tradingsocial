package org.tradingsocial.service;

import org.tradingsocial.model.User;

public interface UserService {
	
	User getUser(int id);
	Integer login(String user, String password);

}
