package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Transfer;
import com.util.JDBCUtil;

/**
 * 
 * @author NaiveKyo
 * 数据访问对象：转账信息
 */
public class TransferDao {
	
	@SuppressWarnings("finally")
	public int insertTransfer(Transfer transfer) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int flag = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String bms_id = transfer.getBms_id();
			String c_id = transfer.getC_id();
			String t_id = transfer.getT_id();
			double t_money = transfer.getT_money();
			
			String sql = "insert into transfer(bms_id,c_id, t_id, t_money) values(?,?,?,?)";
			System.out.println("insertTransfer(Transfer transfer)" + sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bms_id);
			ps.setString(2, c_id);
			ps.setString(3, t_id);
			ps.setDouble(4, t_money);
			
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return flag;
		}
	}
	
	@SuppressWarnings("finally")
	public Transfer selectTransfer(Transfer transfer) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Transfer a = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from transfer where c_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			String c_id = transfer.getC_id();
			
			ps.setString(1, c_id);
			System.out.println("transfer selectTransfer(Transfer transfer) " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new Transfer();
				
				a.setBms_id(rs.getString("bms_id"));
				a.setC_id(rs.getString("c_id"));
				a.setT_id(rs.getString("t_id"));
				a.setT_date(rs.getString("t_date"));
				a.setT_money(rs.getDouble("t_money"));
				a.setC_balance(rs.getDouble("c_balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return a;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Transfer> selectTransferList(Transfer transfer){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Transfer> list = new ArrayList<Transfer>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			StringBuffer sql = new StringBuffer("select * from transfer where 1 = 1");
			
			String bmsid = transfer.getBms_id();
			String cid = transfer.getC_id();
			String date = transfer.getT_date();
			
			if(!("".equals(bmsid)) && bmsid != null) {
				sql.append(" and bms_id = '" + bmsid + "'");
			}
			if(!("".equals(cid)) && cid != null) {
				sql.append(" and c_id = '" + cid + "'");
			}
			if(!("".equals(date)) && date != null) {
				sql.append(" and t_date = '" + date + "'");
			}
			
			ps = conn.prepareStatement(String.valueOf(sql));
			
			System.out.println("transfer selectTransferList(Transfer transfer) " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Transfer a = new Transfer();
				
				a.setBms_id(rs.getString("bms_id"));
				a.setC_id(rs.getString("c_id"));
				a.setT_id(rs.getString("t_id"));
				a.setT_date(rs.getString("t_date"));
				a.setT_money(rs.getDouble("t_money"));
				a.setC_balance(rs.getDouble("c_balance"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return list;
		}
	}
}
