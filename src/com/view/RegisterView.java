package com.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.AdminDao;
import com.entity.Admin;
import com.util.Location;
import com.util.MyFont;

/**
 * 
 * @author NaiveKyo
 * 注册账户界面
 */
public class RegisterView extends JDialog {
	
//	public static void main(String[] args) {
//		RegisterView rv = new RegisterView();
//		rv.setSize(1000, 600);
//		rv.setVisible(true);
//	}
	
	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_user;
	private JPasswordField jpf_psw;
	private JPasswordField jpf_again;
	
	
	/**
	 * Create a dialog
	 */
	public void init() {
		jtf_user.setText("");
		jpf_psw.setText("");
		jpf_again.setText("");
	}
	
	/*
	 * 注册界面
	 */
	public RegisterView() {
		this.setSize(630, 400);
		this.setResizable(false);
		this.setTitle("管理员注册");
		this.getContentPane().setLayout(new BorderLayout());
		
		Location.setCenter(this);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
//		ButtonGroup group = new ButtonGroup();
		
		JPanel jp_back = new JPanel();
		jp_back.setBounds(126, 21, 339, 306);
		contentPanel.add(jp_back);
		jp_back.setLayout(null);
		
//		JLabel jl_role = new JLabel("角   色");
//		jl_role.setBounds(29, 53, 80, 30);
//		jp_back.add(jl_role);
//		jl_role.setFont(MyFont.getMyFont());
		
		JLabel jl_user = new JLabel("用户名");
		jl_user.setBounds(29, 97, 80, 30);
		jp_back.add(jl_user);
		jl_user.setFont(MyFont.getMyFont());
		
		JLabel jl_psw = new JLabel("密   码");
		jl_psw.setBounds(29, 148, 80, 30);
		jp_back.add(jl_psw);
		jl_psw.setFont(MyFont.getMyFont());
		
		JLabel jl_again = new JLabel("重新输入:");
		jl_again.setBounds(29, 198, 80, 30);
		jp_back.add(jl_again);
		jl_again.setFont(MyFont.getMyFont());
		
		jtf_user = new JTextField();
		jtf_user.setBounds(119, 98, 190, 30);
		jp_back.add(jtf_user);
		jtf_user.setColumns(20);
		jtf_user.setFont(MyFont.getMyFont());
		
		jpf_psw = new JPasswordField();
		jpf_psw.setBounds(119, 149, 190, 30);
		jp_back.add(jpf_psw);
		jpf_psw.setFont(MyFont.getMyFont());
		
		jpf_again = new JPasswordField();
		jpf_again.setBounds(120, 199, 190, 30);
		jp_back.add(jpf_again);
		jpf_again.setFont(MyFont.getMyFont());
		
//		rb_admin = new JRadioButton("管理员");
//		rb_admin.setBounds(115, 56, 121, 25);
//		jp_back.add(rb_admin);
//		rb_admin.setFont(MyFont.getMyFont());
//		
//		rb_user = new JRadioButton("用户");
//		rb_user.setBounds(254, 57, 55, 25);
//		jp_back.add(rb_user);
//		rb_user.setFont(MyFont.getMyFont());
//		
//		group.add(rb_admin);
//		group.add(rb_user);
		
		JButton jb_submit = new JButton("注册");
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String psw = String.valueOf(jpf_psw.getPassword());
				String again_psw = String.valueOf(jpf_again.getPassword());
				String user = jtf_user.getText().trim();
//				System.out.println(user + " " + psw + " " + again_psw);
//				if(rb_admin.isSelected()) {
					
					Admin a = new Admin();
					a.setBms_id(user);
					
					Admin admin = new AdminDao().selectAdmin(a);
					
					if(admin != null) {
						JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>用户名已存在</font></html>");
						init();
						return;
					} else {
						if((!(psw).equals(again_psw)) || "".equals(psw)){
							JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>密码输入错误</font></html>");
							init();
							return;
						} else {
							Admin admin1 = new Admin(user, psw);
							int flag = new AdminDao().insertAdmin(admin1);
							if(flag == 1) {
								JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>注册成功!</font></html>");
								RegisterView.this.dispose();
								new LoginView();
							} else {
								init();
								JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>注册失败</font></html>");
							}
						}
					}
//				} else if(rb_user.isSelected()) {
//					Customer c = new Customer();
//					c.setC_id(user);
//					
//					Customer customer = new CustomerDao().selectCustomer(c);
//					
//					if(customer != null) {
//						JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>用户名已存在</font></html>");
//						init();
//						return;
//					} else {
//						if(!(psw).equals(again_psw) || "".equals(psw) || "".equals(again_psw)){
//							JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>密码输入错误</font></html>");
//							init();
//							return;
//						} else {
//							Customer c1 = new Customer();
//							
//						}
//				}
//			}
		}
		});
		
		jb_submit.setBounds(120, 245, 80, 30);
		jp_back.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());
		
		JButton jb_reset = new JButton("重置");
		
		jb_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				init();
			}
		});
		
		jb_reset.setBounds(230, 245, 80, 30);
		jp_back.add(jb_reset);
		jb_reset.setFont(MyFont.getMyFont());
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				new LoginView().setVisible(true);
			}
		});
	}
}
