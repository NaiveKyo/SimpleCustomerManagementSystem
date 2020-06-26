package com.entity;

/**
 * 
 * @author NaiveKyo
 * 银行客户实体类
 */
public class Customer {
	
	private String c_id;			// 客户账号
	private	String c_name;			// 客户姓名
	private String c_pswd;			// 账号密码
	private String c_identity;		// 客户身份证
	private double c_balance = 0;		// 账户余额
	private String c_status;		// 账户状态
	private String c_adress;		// 客户住址
	private String c_date;			// 开户日期
	
	/**
	 * 无参构造函数
	 */
	public Customer() {
	
	}
	
	
	/**
	 * 
	 * @param c_id
	 */
	public Customer(String c_id) {
		super();
		this.c_id = c_id;
	}



	/**
	 * 
	 * @param c_id
	 * @param c_pswd
	 */
	public Customer(String c_id, String c_pswd) {
		super();
		this.c_id = c_id;
		this.c_pswd = c_pswd;
	}

	/**
	 * 有参构造函数
	 * @param c_id
	 * @param c_name
	 * @param c_pswd
	 * @param c_identity
	 * @param c_balance
	 * @param c_status
	 * @param c_adress
	 * @param c_date
	 */
	public Customer(String c_id, String c_name, String c_pswd, String c_identity, double c_balance, String c_status,
			String c_adress, String c_date) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_pswd = c_pswd;
		this.c_identity = c_identity;
		this.c_balance = c_balance;
		this.c_status = c_status;
		this.c_adress = c_adress;
		this.c_date = c_date;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_pswd() {
		return c_pswd;
	}

	public void setC_pswd(String c_pswd) {
		this.c_pswd = c_pswd;
	}

	public String getC_identity() {
		return c_identity;
	}

	public void setC_identity(String c_identity) {
		this.c_identity = c_identity;
	}

	public double getC_balance() {
		return c_balance;
	}

	public void setC_balance(double c_balance) {
		this.c_balance = c_balance;
	}

	public String getC_status() {
		return c_status;
	}

	public void setC_status(String c_status) {
		this.c_status = c_status;
	}

	public String getC_adress() {
		return c_adress;
	}

	public void setC_adress(String c_adress) {
		this.c_adress = c_adress;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	
	
}
