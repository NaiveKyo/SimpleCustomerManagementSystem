package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.entity.Admin;
import com.entity.Customer;
import com.main.BankSystem;
import com.util.ImagePanel;
import com.util.Location;
import com.util.MyFont;

public class IndexView extends JFrame implements MouseListener {
	
	private JPanel centerPanel;
	private JPanel menuPanel;
	
	// 管理员标签
	private JLabel jl_index;		// 首页
	private JLabel jl_customer;		// 客户管理（信息查询：客户信息，银行卡信息）
	private JLabel jl_deposit;		// 业务处理（存款、取款、转账）
	private JLabel jl_withdrawal;
	private JLabel jl_transfer;
	private JLabel jl_customerMsgQuery;	// 客户信息查询
	private JLabel jl_user;			// 用户管理（更改密码）
	private JLabel jl_exit;			// 注销登录
	private JLabel jl_welcome;		// 欢迎用户登录
	
	// 客户标签
	private JLabel jl_accountInfo;		// 银行卡信息
//	private JLabel jl_business;			// 业务处理
	private JLabel jl_tradeInfo;		// 账户流水
//	private JLabel jl_user;				// 用户管理（更改信息）
//	private JLabel jl_exit;				// 注销
//	private JLabel jl_welcome;			// 欢迎用户登录
	
	// 返回查询信息
	int flag_index;
	int flag_customer;
	int flag_deposit;
	int flag_withdrawal;
	int flag_transfer;
	int flag_customerMsgQuery;
	int flag_user;
	int flag_accountInfo;
	int flag_tradeInfo;
	
	private Admin admin = null;
	private Customer customer = null;
	
	// 测试
//	public static void main(String[] args) {
//		Admin a = new Admin();
//		a.setBms_id("测试管理员1");
//		IndexView i = new IndexView();
//		i.setVisible(true);
//	}
	
	/**
	 * 无参构造函数
	 */
	public IndexView() {
		
	}
	
	public void closeIndex() {
		this.dispose();
	}
	
	/**
	 * 管理员界面
	 * @param admin
	 */
	public IndexView(Admin admin) {
		this.setTitle("银行客户管理系统");
		this.admin = admin;
		this.setSize(1000, 600);
		this.setResizable(false);
		
		Location.setCenter(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initAdminMenuPanel();
		
		jl_welcome.setText("欢迎管理员: " + admin.getBms_id() + " 登录");
		jl_welcome.setFont(MyFont.getMyFont());
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	/**
	 * 用户界面
	 * @param customer
	 */
	public IndexView(Customer customer) {
		this.setTitle("银行客户管理系统");
		this.customer = customer;
		this.setSize(1000, 600);
		this.setResizable(false);
		
		Location.setCenter(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initCustomerMenuPanel();
		
		jl_welcome.setText("欢迎用户: " + customer.getC_name() + " 登录");
		jl_welcome.setFont(MyFont.getMyFont());
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	/**
	 * 初始化面板
	 * @return
	 */
	public JPanel initCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		return panel;
	}
	
	/**
	 * 初始化菜单
	 * @param name
	 * @return
	 */
	public JLabel initMenu(String name) {
		JLabel menu = new JLabel();
		menu.setFont(MyFont.getMyFont());
		menu.setPreferredSize(new Dimension(94, 40));
		menu.setText("<html><font color='black'>" + name + " | " + "</font></html>");
		menu.addMouseListener(this);
		return menu;
	}
	
	/**
	 * 管理员菜单
	 * @return
	 */
	public JPanel initAdminMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(850, 50));	// mark
		
		jl_welcome = new JLabel();
		jl_welcome.setIcon(new ImageIcon("image/login_001.png"));
		jl_welcome.setFont(MyFont.getMyFont());
		
		FlowLayout flowLayout = (FlowLayout)menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		jl_index = initMenu("首页");
		jl_index.setIcon(new ImageIcon("image/index.png"));
		jl_customer = initMenu("客户管理");
		jl_customer.setIcon(new ImageIcon("image/customer.png"));
		jl_deposit = initMenu("存款业务");
		jl_deposit.setIcon(new ImageIcon("image/business.png"));
		jl_withdrawal = initMenu("取款业务");
		jl_withdrawal.setIcon(new ImageIcon("image/business.png"));
		jl_transfer = initMenu("转账业务");
		jl_transfer.setIcon(new ImageIcon("image/business.png"));
//		jl_customerMsgQuery = initMenu("信息查询");
//		jl_customerMsgQuery.setIcon(new ImageIcon("image/query.png"));
//		jl_user = initMenu("用户管理");
//		jl_user.setIcon(new ImageIcon("image/user.png"));
		
		jl_exit = new JLabel();
		jl_exit.setFont(MyFont.getMyFont());
		jl_exit.setPreferredSize(new Dimension(94, 40));
		jl_exit.setText("<html><font color='black' >注销登录</font></html>");
		jl_exit.addMouseListener(this);
		jl_exit.setIcon(new ImageIcon("image/exit.png"));
		
		menuPanel.add(jl_index);
		menuPanel.add(jl_customer);
		menuPanel.add(jl_deposit);
		menuPanel.add(jl_withdrawal);
		menuPanel.add(jl_transfer);
//		menuPanel.add(jl_customerMsgQuery);
//		menuPanel.add(jl_user);
		menuPanel.add(jl_exit);
		menuPanel.add(new JLabel("                                                                      "));
		menuPanel.add(jl_welcome);
		
		createIndex();
		return menuPanel;
	}
	
	/**
	 * 客户界面
	 * @return
	 */
	public JPanel initCustomerMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(850, 50));
		
		jl_welcome = new JLabel();
		jl_welcome.setIcon(new ImageIcon("image/login_001.png"));
		
		FlowLayout flowLayout = (FlowLayout)menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		jl_index = initMenu("首页");
		jl_index.setIcon(new ImageIcon("image/index.png"));
		jl_accountInfo = initMenu("账号信息");
		jl_accountInfo.setIcon(new ImageIcon("image/accountInfo.png"));
//		jl_deposit = initMenu("业务处理");
//		jl_deposit.setIcon(new ImageIcon("image/business.png"));
		jl_tradeInfo = initMenu("交易信息");
		jl_tradeInfo.setIcon(new ImageIcon("image/query.png"));
		jl_user = initMenu("用户管理");
		jl_user.setIcon(new ImageIcon("image/user.png"));
		jl_exit = initMenu("注销登录");
		jl_exit.setIcon(new ImageIcon("image/exit.png"));
		
		menuPanel.add(jl_index);
		menuPanel.add(jl_accountInfo);
//		menuPanel.add(jl_deposit);
		menuPanel.add(jl_tradeInfo);
		menuPanel.add(jl_user);
		menuPanel.add(jl_exit);
		menuPanel.add(new JLabel("                                                                                                                       "));
		menuPanel.add(jl_welcome);
		
		createIndex();
		return menuPanel;
	}
	
	/**
	 * 首页界面
	 */
	public void createIndex() {
		
		centerPanel.removeAll();
		
		flag_index = 1;
		flag_customer = 0;
		flag_deposit = 0;
		flag_withdrawal = 0;
		flag_transfer = 0;
		flag_customerMsgQuery = 0;
		flag_user = 0;
		flag_accountInfo = 0;
		flag_tradeInfo = 0;
		
		jl_index.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页   |"
					+ "</font>&nbsp;</html>");
		jl_index.setPreferredSize(new Dimension(70, 40));
		
		ImagePanel backPanel = ViewFactory.getIndexBackPanel();
		
		centerPanel.add(backPanel);
		
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	}
	
	/**
	 * 管理员界面: 客户信息管理(开户、销户、挂失、修改)
	 */
	public void createAdminCustomer() {
		centerPanel.removeAll();
		
		flag_index = 0;
		flag_customer = 1;
		flag_deposit = 0;
		flag_withdrawal = 0;
		flag_transfer = 0;
		flag_customerMsgQuery = 0;
		flag_user = 0;
		flag_accountInfo = 0;
		flag_tradeInfo = 0;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getCustomerManagerPanel();
		tab.add("客户管理", jp);
		centerPanel.add(tab);
	}
	
	/**
	 * 管理员存款业务处理
	 */
	public void createAdminBusinessDeposit() {
		centerPanel.removeAll();
		
		flag_index = 0;
		flag_customer = 0;
		flag_deposit = 1;
		flag_withdrawal = 0;
		flag_transfer = 0;
		flag_customerMsgQuery = 0;
		flag_user = 0;
		flag_accountInfo = 0;
		flag_tradeInfo = 0;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getBusinessDepositPanel(admin.getBms_id());
		tab.add("存款业务处理", jp);
		centerPanel.add(tab);
	}
	
	/**
	 * 管理员取款业务处理
	 */
	public void createAdminBusinessWithdrawal() {
		centerPanel.removeAll();
		
		flag_index = 0;
		flag_customer = 0;
		flag_deposit = 0;
		flag_withdrawal = 1;
		flag_transfer = 0;
		flag_customerMsgQuery = 0;
		flag_user = 0;
		flag_accountInfo = 0;
		flag_tradeInfo = 0;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getBusinessWithdrawalPanel(admin.getBms_id());
		tab.add("取款业务处理", jp);
		centerPanel.add(tab);
	}
	
	/**
	 * 管理员转账业务处理
	 */
	public void createAdminBusinessTransfer() {
		centerPanel.removeAll();
		
		flag_index = 0;
		flag_customer = 0;
		flag_deposit = 0;
		flag_withdrawal = 0;
		flag_transfer = 1;
		flag_customerMsgQuery = 0;
		flag_user = 0;
		flag_accountInfo = 0;
		flag_tradeInfo = 0;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getBusinessTransferPanel(admin.getBms_id());
		tab.add("转账业务处理", jp);
		centerPanel.add(tab);
	}
	
	/**
	 * 用户界面修改账号密码
	 */
	public void createUser() {
		centerPanel.removeAll();
		
		flag_index = 0;
//		flag_customer = 0;
//		flag_deposit = 0;
//		flag_withdrawal = 0;
//		flag_transfer = 0;
//		flag_customerMsgQuery = 0;
		flag_user = 1;
		flag_accountInfo = 0;
		flag_tradeInfo = 0;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		
		if(customer != null) {
			JPanel jp1 = ViewFactory.getCustomerInformationPanel(customer);
			JPanel jp2 = ViewFactory.getCustomerUpdatePswView(customer);
			tab.add("基本信息", jp1);
			tab.add("修改密码", jp2);
			centerPanel.add(tab);
		}
	}
	
	/**
	 * 用户界面: 当前账户信息
	 */
	public void createAccountInfo() {
		centerPanel.removeAll();
		
		flag_index = 0;
		flag_user = 0;
		flag_tradeInfo = 0;
		flag_accountInfo = 1;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		
		if(customer != null) {
			JPanel jp = ViewFactory.getCustomerAccountMessageView(customer);
	
			tab.add("账号信息", jp);
			centerPanel.add(tab);
		}
	}
	
	/**
	 * 当前账户流水
	 */
	public void createTrade() {
		centerPanel.removeAll();
		
		flag_index = 0;
		flag_user = 0;
		flag_tradeInfo = 1;
		flag_accountInfo = 0;
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		
		if(customer != null) {
			JPanel jp1 = ViewFactory.getCustomerDepositTradeView(customer);
			JPanel jp2 = ViewFactory.getCustomerWithdrawalTradeView(customer);
			JPanel jp3 = ViewFactory.getCustomerTransferTradeView(customer);
			tab.add("存款信息", jp1);
			tab.add("取款信息", jp2);
			tab.add("转账信息", jp3);
			centerPanel.add(tab);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_index) {
			if (flag_index == 0) {
				this.createIndex();
			}
		} else if(e.getSource() == jl_customer) {
			if(flag_customer == 0) {
				this.createAdminCustomer();
			}
		} else if(e.getSource() == jl_user) {
			if(flag_user == 0) {
				this.createUser();
			}
		} else if(e.getSource() == jl_deposit) {
			if(flag_deposit == 0) {
				this.createAdminBusinessDeposit();;
			}
		} else if(e.getSource() == jl_withdrawal) {
			if(flag_withdrawal == 0) {
				this.createAdminBusinessWithdrawal();
			}
		} else if(e.getSource() == jl_transfer) {
			if(flag_transfer == 0) {
				this.createAdminBusinessTransfer();
			}
		} else if(e.getSource() == jl_tradeInfo) {
			if(flag_tradeInfo == 0) {
				this.createTrade();
			}
		} else if(e.getSource() == jl_accountInfo) {
			if(flag_accountInfo == 0) {
				this.createAccountInfo();
			}
		}
//		else if(e.getSource() == jl_customerMsgQuery) {
//			if(flag_customerMsgQuery == 0) {
//				this.createCustomerMsgQuery();
//			}
//		}
//		else if(e.getSource() == jl_tradeInfo) {
//			if(flag_tradeInfo == 0) {
//				this.createTradeInfo();
//			}
//		}
//		else if(e.getSource() == jl_accountInfo) {
//			if(flag_accountInfo == 0) {
//				this.createAccountInfo();
//			}
//		}
		else if(e.getSource() == jl_exit) {
			BankSystem.main(null);
			this.dispose();
		} else {
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_index) {
			jl_index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_index.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页   | " + "</font></html>");
		} else if(e.getSource() == jl_customer) {
			jl_customer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_customer.setText("<html><font color='#336699' style='font-weight:bold'>" + "客户管理   | " + "</font></html>");
		} else if(e.getSource() == jl_exit) {
			jl_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_exit.setText("<html><font color='#336699' style='font-weight:bold'>" + "注销登录  | " + "</font></html>");
		} else if(e.getSource() == jl_deposit) {
			jl_deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_deposit.setText("<html><font color='#336699' style='font-weight:bold'>" + "存款业务   | " + "</font></html>");
		} else if(e.getSource() == jl_withdrawal) {
			jl_withdrawal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_withdrawal.setText("<html><font color='#336699' style='font-weight:bold'>" + "取款业务   | " + "</font></html>");
		} else if(e.getSource() == jl_transfer) {
			jl_transfer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_transfer.setText("<html><font color='#336699' style='font-weight:bold'>" + "转账业务   | " + "</font></html>");
		} else if(e.getSource() == jl_user) {
			jl_user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_user.setText("<html><font color='#336699' style='font-weight:bold'>" + "用户管理   | " + "</font></html>");
		} else if(e.getSource() == jl_tradeInfo) {
			jl_tradeInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_tradeInfo.setText("<html><font color='#336699' style='font-weight:bold'>" + "交易信息   | " + "</font></html>");
		} else if(e.getSource() == jl_accountInfo) {
			jl_accountInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_accountInfo.setText("<html><font color='#336699' style='font-weight:bold'>" + "账号信息   | " + "</font></html>");
		} else {
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_index) {
			jl_index.setText("<html><font color='black'>" + "首页   | " + "</font></html>");
		} else if (e.getSource() == jl_customer) {
			jl_customer.setText("<html><font color='black' >" + "客户管理   | " + "</font></html>");
		} else if(e.getSource() == jl_deposit) {
			jl_deposit.setText("<html><font color='black' >" + "存款业务   | " + "</font></html>");
		} else if(e.getSource() == jl_exit) {
			jl_exit.setText("<html><font color='black' >" + "注销登录   | " + "</font></html>");
		} else if(e.getSource() == jl_withdrawal) {
			jl_withdrawal.setText("<html><font color='black' >" + "取款业务   | " + "</font></html>");
		} else if(e.getSource() == jl_transfer) {
			jl_transfer.setText("<html><font color='black' >" + "转账业务   | " + "</font></html>");
		} else if(e.getSource() == jl_user) {
			jl_user.setText("<html><font color='black' >" + "用户管理   | " + "</font></html>");
		} else if(e.getSource() == jl_tradeInfo ) {
			jl_tradeInfo.setText("<html><font color='black' >" + "交易信息   | " + "</font></html>");
		} else if(e.getSource() == jl_accountInfo) {
			jl_accountInfo.setText("<html><font color='black' >" + "账号信息   | " + "</font></html>");
		} else {
			
		}
	}
}
