package org.tradingsocial.dao;

import java.util.List;

import org.tradingsocial.model.UserActions;

public interface UserActionsDAO {

	UserActions getUserActionsById(int id);
	List<UserActions> getUserActionsBySourceUserId(int sourceUserId);
	List<UserActions> getUserTweetsbyStockId(int targetStockId);
	List<UserActions> getUserActionsBy(int targetStockId);
	void saveOrUpdate(UserActions userActions);
	void delete(int id);
	List<UserActions> getAllUserActions();
}
