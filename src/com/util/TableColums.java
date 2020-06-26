package com.util;

public class TableColums {
	
	public static String[] getCustomerColums() {
		String[] colums = new String[] {
			"账号", "密码", "姓名", "余额", "状态", "开户日期", "籍贯", "身份证"
		};
		return colums;
	}
	
	public static String[] getDepositColums() {
		String[] colums = new String[] {
			"处理人员", "账号", "存款日期", "存款金额", "账户余额"	
		};
		return colums;
	}
	
	public static String[] getWithdrawalColums() {
		String[] colums = new String[] {
			"处理人员", "账号", "取款日期", "取款金额", "账户余额"
		};
		return colums;
	}
	
	public static String[] getTransferColums() {
		String[] colums = new String[] {
			"处理人员", "账户", "接收方账户", "转账日期", "转账金额", "账户余额"	
		};
		return colums;
	}
}
