package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author NaiveKyo
 * 数据库和 java日期类型转换
 */ 
public class FormatToDate {

	public static java.sql.Date getDate(String date){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d;
		
		try {
			if(!"".equals(date)) {
				d = format.parse(date);
				System.out.println(d);
				java.sql.Date dd = new java.sql.Date(d.getTime());
				return dd;
			}
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
