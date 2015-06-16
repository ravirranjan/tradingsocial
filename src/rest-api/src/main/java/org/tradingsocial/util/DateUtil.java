package org.tradingsocial.util;

import java.sql.Timestamp;
import java.util.Date;

public final class DateUtil {

	public static Timestamp convertToSQlTimestamp(Date date) {
		// TODO Auto-generated method stub
		return new Timestamp(date.getTime());
	}
	
	public static java.sql.Date convertToSQlDate(Date date) {
		// TODO Auto-generated method stub
		return new java.sql.Date(date.getTime());
	}

}
