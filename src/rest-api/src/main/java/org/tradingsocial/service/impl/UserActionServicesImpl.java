package org.tradingsocial.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.tradingsocial.dao.UserActionsDAO;
import org.tradingsocial.dao.UserDAO;
import org.tradingsocial.model.UserActions;
import org.tradingsocial.service.UserActionServices;
import org.tradingsocial.util.DateUtil;

public class UserActionServicesImpl implements UserActionServices{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserActionsDAO userActionsDAO;
	
	public void logUserTweet(String actionType, Integer sourceUserId,
			Date actionTime, String actionContent, Integer targetUserId,
			Integer targetStockId) {
		UserActions actions =  new UserActions();
		actions.setActionTime(DateUtil.convertToSQlTimestamp(new Date()));
		actions.setSourceUserId(sourceUserId);
		actions.setActionType(actionType);
		actions.setTargetStockId(targetStockId);
		actions.setTargetUserId(targetUserId);
		
		userActionsDAO.saveOrUpdate(actions);
		
	}

	public void logUserAction(String actionType, Integer sourceUserId,
			Date actionTime) {
		UserActions actions =  new UserActions();
		actions.setActionTime(DateUtil.convertToSQlTimestamp(new Date()));
		actions.setSourceUserId(sourceUserId);
		actions.setActionType(actionType);
		actions.setTargetStockId(1);
		actions.setTargetUserId(sourceUserId);
		
		userActionsDAO.saveOrUpdate(actions);
	}

}
