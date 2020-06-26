package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 
 * @author NaiveKyo
 * JDBC 工具类
 */
public class JDBCUtil {
	
	static final String DRIVERCLASS;
	static final String URL;
	static final String USERNAME;
	static final String PASSWORD;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("lib.jdbc");
		
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USERNAME = bundle.getString("username");
		PASSWORD = bundle.getString("password");
	}
	
	// test
//	public static void main(String[] args) {
//		System.out.println(DRIVERCLASS + "\n" + URL + "\n" + USERNAME + "\n" + PASSWORD);
//	}
	
	static {
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	/**
	 * 释放数据库资源
	 * @param conn
	 * @param stm
	 * @param rs
	 */
	public static void closeResource(Connection conn, Statement stm, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stm);
		closeConnection(conn);
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatement(Statement stm) {
		if(stm != null) {
			try {
				stm.close();
				stm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
