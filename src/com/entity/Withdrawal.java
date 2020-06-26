package com.entity;

/**
 * 
 * @author NaiveKyo
 * 取款单信息实体类
 */
public class Withdrawal {

	private String bms_id;			// 管理员账户
	private String c_id;			// 取款账户
	private String w_date;			// 取款日期
	private double w_money;			// 取款金额
	private double c_balance;		// 账户余额
	
	/**
	 * 无参构造函数
	 */
	public Withdrawal() {

	}

	/**
	 * 
	 * @param c_id
	 */
	public Withdrawal(String c_id) {
		super();
		this.c_id = c_id;
	}


	/**
	 * 
	 * @param bms_id
	 * @param c_id
	 * @param w_date
	 * @param w_money
	 * @param c_balance
	 */
	public Withdrawal(String bms_id, String c_id, String w_date, double w_money, double c_balance) {
		super();
		this.bms_id = bms_id;
		this.c_id = c_id;
		this.w_date = w_date;
		this.w_money = w_money;
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

	public String getW_date() {
		return w_date;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	public double getW_money() {
		return w_money;
	}

	public void setW_money(double w_money) {
		this.w_money = w_money;
	}

	public double getC_balance() {
		return c_balance;
	}

	public void setC_balance(double c_balance) {
		this.c_balance = c_balance;
	}
}
