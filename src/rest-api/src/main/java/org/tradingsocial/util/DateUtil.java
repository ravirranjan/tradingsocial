package org.tradingsocial.util;

import java.util.Date;

public final class DateUtil {

	public static java.sql.Date convertToSQlDate(Date date){
		return new java.sql.Date(date.getTime());
	}
	
	public static java.sql.Timestamp convertToSQlTimestamp(Date date){
		return new java.sql.Timestamp(date.getTime());
	}
}
