package com.entity;

/**
 * 
 * @author NaiveKyo
 * 银行管理员实体类
 */
public class Admin {

	private String bms_id;			// 管理员账户
	private String bms_pswd;	// 管理员密码
	
	/**
	 * 无参构造函数
	 */
	public Admin() {
	
	}

	/**
	 * 有参构造函数
	 * @param bMS_ID
	 * @param bMS_PSWD
	 */
	public Admin(String bMS_ID, String bMS_PSWD) {
		super();
		bms_id = bMS_ID;
		bms_pswd = bMS_PSWD;
	}

	public String getBms_id() {
		return bms_id;
	}

	public void setBms_id(String bms_id) {
		this.bms_id = bms_id;
	}

	public String getBms_pswd() {
		return bms_pswd;
	}

	public void setBms_pswd(String bms_pswd) {
		this.bms_pswd = bms_pswd;
	}

}
