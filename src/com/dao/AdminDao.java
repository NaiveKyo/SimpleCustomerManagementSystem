package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Admin;
import com.util.JDBCUtil;

/**
 * 
 * @author NaiveKyo
 * 数据访问对象：银行管理员
 */
public class AdminDao {
	
	@SuppressWarnings("finally")
	public Admin selectAdmin(Admin admin) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin1 = null;
		
		try {
			conn = JDBCUtil.getConnection();
	
			String bms_id = admin.getBms_id();
			
			String sql = "select * from admin where bms_id = ?";
			
			ps = conn.prepareStatement(sql);
			System.out.println("selectAdmin(Admin admin)" + sql);
			
			ps.setString(1, bms_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				admin1 = new Admin();
				admin1.setBms_id(rs.getString("BMS_ID"));
				admin1.setBms_pswd(rs.getString("BMS_PSWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return admin1;
		}
	}
	
	@SuppressWarnings("finally")
	public Admin selectAdminWithPSW(Admin admin) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin1 = null;
		
		try {
			conn = JDBCUtil.getConnection();
	
			String bms_id = admin.getBms_id();
			String bms_pswd = admin.getBms_pswd();
			
			String sql = "select * from admin where bms_id = ? and bms_pswd = ?";
			
			ps = conn.prepareStatement(sql);
			System.out.println("selectAdminWithPSW(Admin admin)" + sql);
			
			ps.setString(1, bms_id);
			ps.setString(2, bms_pswd);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				admin1 = new Admin();
				admin1.setBms_id(rs.getString("BMS_ID"));
				admin1.setBms_pswd(rs.getString("BMS_PSWD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return admin1;
		}
	}
	
	@SuppressWarnings("finally")
	public int insertAdmin(Admin admin) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int flag = 0;
		
		try {
			conn = JDBCUtil.getConnection();
	
			String bms_id = admin.getBms_id();
			String bms_pswd = admin.getBms_pswd();
			
			String sql = "insert into admin values(?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bms_id);
			ps.setString(2, bms_pswd);
			
			System.out.println("insertAdmin(Admin admin)" + sql);
			
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return flag;
		}
	}
	
	public List<Admin> selectAdminList(Admin admin){
		return null;
	}
}
