package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Withdrawal;
import com.util.JDBCUtil;

/**
 * 
 * @author NaiveKyo
 * 数据访问对象：取款单信息
 */
public class WithdrawalDao {
	
	@SuppressWarnings("finally")
	public int insertWithdrawal(Withdrawal withdrawal) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int flag = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String bms_id = withdrawal.getBms_id();
			String c_id = withdrawal.getC_id();
			double w_money = withdrawal.getW_money();
			
			String sql = "insert into withdrawal(bms_id, c_id, w_money) values(?,?,?)";
			System.out.println("insertWithdrawal(Withdrawal withdrawal)" + sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bms_id);
			ps.setString(2, c_id);
			ps.setDouble(3, w_money);
			
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return flag;
		}
	}
	
	@SuppressWarnings("finally")
	public Withdrawal selectWithdrawal(Withdrawal withdrawal) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Withdrawal a = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from withdrawal where c_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			String c_id = withdrawal.getC_id();
			
			ps.setString(1, c_id);
			
			System.out.println("withdrawal selectWithdrawal(Withdrawal withdrawal) " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new Withdrawal();
				a.setBms_id(rs.getString("bms_id"));
				a.setC_id(rs.getString("c_id"));
				a.setW_date(rs.getString("w_date"));
				a.setW_money(rs.getDouble("w_money"));
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
	public List<Withdrawal> selectWithdrawalList(Withdrawal withdrawal){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Withdrawal> list = new ArrayList<Withdrawal>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String bms_id = withdrawal.getBms_id();
			String c_id = withdrawal.getC_id();
			String w_date = withdrawal.getW_date();
//			Double w_money = withdrawal.getW_money();
//			Double c_balance = withdrawal.getC_balance();
			
			StringBuffer sql = new StringBuffer("select * from withdrawal where 1=1");
			System.out.println("selectWithdrawalList(Withdrawal withdrawal)" + sql);
			
			if(!"".equals(bms_id) && bms_id != null) {
				sql.append(" and bms_id = '" + bms_id + "'");
			}
			
			if(!("".equals(c_id)) && c_id != null) {
				sql.append(" and c_id = '" + c_id + "'");
			}
			
			if(!("".equals(w_date)) && w_date != null) {
				sql.append(" and w_date = '" + w_date + "'");
			}
			
//			if(!"".equals(w_money) && w_money != null) {
//				sql.append(" and w_money = " + w_money);
//			}
//			
//			if(!"".equals(c_balance) && c_balance != null) {
//				sql.append(" and c_balance = " + c_balance);
//			}
			ps = conn.prepareStatement(String.valueOf(sql));
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Withdrawal a = new Withdrawal();
				a.setBms_id(rs.getString("bms_id"));
				a.setC_id(rs.getString("c_id"));
				a.setW_date(rs.getString("w_date"));
				a.setW_money(rs.getDouble("w_money"));
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
