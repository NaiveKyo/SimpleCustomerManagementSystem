package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Deposit;
import com.util.JDBCUtil;

/**
 * 
 * @author NaiveKyo
 * 数据访问对象：存款单信息
 */
public class DepositDao {
	
	@SuppressWarnings("finally")
	public int insertDeposit(Deposit deposit) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int flag = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String bms_id = deposit.getBms_id();
			String c_id = deposit.getC_id();
			double d_money = deposit.getD_money();

			
			String sql = "insert into deposit(bms_id, c_id, d_money) values(?,?,?)";
			System.out.println("insertDeposit(Deposit deposit)" + sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bms_id);
			ps.setString(2, c_id);
			ps.setDouble(3, d_money);
			
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
			return flag;
		}
	}
	
	@SuppressWarnings("finally")
	public Deposit selectDeposit(Deposit deposit) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Deposit a = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from deposit where c_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			String c_id = deposit.getC_id();
			
			ps.setString(1, c_id);
			System.out.println("deposit selectDeposit(Deposit deposit) " + ps.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				a = new Deposit();
				a.setBms_id(rs.getString("bms_id"));
				a.setC_id(rs.getString("c_id"));
				a.setD_date(rs.getString("d_date"));
				a.setD_money(rs.getDouble("c_money"));
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
	public List<Deposit> selectDepositList(Deposit deposit){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Deposit> list = new ArrayList<Deposit>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String bms_id = deposit.getBms_id();
			String c_id = deposit.getC_id();
			String d_date = deposit.getD_date();
//			Double d_money = deposit.getD_money();
//			Double c_balance = deposit.getC_balance();
			
			StringBuffer sql = new StringBuffer("select * from deposit where 1=1");
			System.out.println("selectDepositList(Deposit deposit)" + sql);
			
			if(!"".equals(bms_id) && bms_id != null) {
				sql.append(" and bms_id = '" + bms_id + "'");
			}
			if(!("".equals(c_id)) && c_id != null) {
				sql.append(" and c_id = '" + c_id + "'");
			}
			
			if(!("".equals(d_date)) && d_date != null) {
				sql.append(" and d_date = '" + d_date + "'");
			}
			
//			if(!"".equals(d_money) && d_money != null) {
//				sql.append(" and d_money = " + d_money);
//			}
//			
//			if(!"".equals(c_balance) && c_balance != null) {
//				sql.append(" and c_balance = " + c_balance);
//			}
			ps = conn.prepareStatement(String.valueOf(sql));
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Deposit a = new Deposit();
				a.setBms_id(rs.getString("bms_id"));
				a.setC_id(rs.getString("c_id"));
				a.setD_date(rs.getString("d_date"));
				a.setD_money(rs.getDouble("d_money"));
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
