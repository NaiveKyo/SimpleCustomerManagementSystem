package com.entity;

/**
 * 
 * @author NaiveKyo
 * 存款单信息实体类
 */
public class Deposit {

	private String bms_id;			// 管理员账户
	private String c_id;			// 存款账号 
	private String d_date;			// 存款日期
	private double d_money;			// 存款金额
	private double c_balance;		// 账户余额
	
	/**
	 * 无参构造函数
	 */
	public Deposit() {
		
	}
	
	
	/**
	 * 
	 * @param c_id
	 */
	public Deposit(String c_id) {
		super();
		this.c_id = c_id;
	}



	/**
	 * 有参构造函数
	 * @param bms_id
	 * @param c_id
	 * @param d_date
	 * @param d_money
	 * @param c_balance
	 */
	public Deposit(String bms_id, String c_id, String d_date, double d_money, double c_balance) {
		super();
		this.bms_id = bms_id;
		this.c_id = c_id;
		this.d_date = d_date;
		this.d_money = d_money;
		this.c_balance = c_balance;
	}

	public String getBms_id() {
		return bms_id;
	}

	public void setBms_id(String bms_id) {
		this.bms_id = bms_id;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getD_date() {
		return d_date;
	}

	public void setD_date(String d_date) {
		this.d_date = d_date;
	}

	public double getD_money() {
		return d_money;
	}

	public void setD_money(double d_money) {
		this.d_money = d_money;
	}

	public double getC_balance() {
		return c_balance;
	}

	public void setC_balance(double c_balance) {
		this.c_balance = c_balance;
	}
}
