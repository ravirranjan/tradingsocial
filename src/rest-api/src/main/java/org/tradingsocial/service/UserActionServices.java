package org.tradingsocial.service;

import java.util.Date;

public interface UserActionServices {

	void logUserTweet(String actionType, Integer sourceUserId, Date actionTime, String actionContent, Integer targetUserId, Integer targetStockId);
	
	void logUserAction(String actionType, Integer sourceUserId, Date actionTime);
	
}
