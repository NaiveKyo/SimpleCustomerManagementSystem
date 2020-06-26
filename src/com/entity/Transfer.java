package com.entity;

/**
 * 
 * @author NaiveKyo
 * ת����Ϣʵ����
 */
public class Transfer {

	private String bms_id;			// ����Ա�˻�
	private String c_id;			// �ͻ��˻�
	private String t_id;			// �ͻ�ת���˻�
	private String t_date;			// ת������
	private double t_money;			// ת�˽��
	private double c_balance;		// �ͻ����

	
	/**
	 * �޲ι��캯��
	 */
	public Transfer() {
		
	}

	/**
	 * 
	 * @param c_id
	 */
	public Transfer(String c_id) {
		super();
		this.c_id = c_id;
	}


	/**
	 * 
	 * @param bms_id
	 * @param c_id
	 * @param t_id
	 * @param t_date
	 * @param t_money
	 * @param c_balance
	 */
	public Transfer(String bms_id, String c_id, String t_id, String t_date, double t_money, double c_balance) {
		super();
		this.bms_id = bms_id;
		this.c_id = c_id;
		this.t_id = t_id;
		this.t_date = t_date;
		this.t_money = t_money;
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

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_date() {
		return t_date;
	}

	public void setT_date(String t_date) {
		this.t_date = t_date;
	}

	public double getT_money() {
		return t_money;
	}

	public void setT_money(double t_money) {
		this.t_money = t_money;
	}

	public double getC_balance() {
		return c_balance;
	}

	public void setC_balance(double c_balance) {
		this.c_balance = c_balance;
	}
}
