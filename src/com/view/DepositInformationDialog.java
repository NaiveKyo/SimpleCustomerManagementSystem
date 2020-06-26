package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.CustomerDao;
import com.dao.DepositDao;
import com.entity.Admin;
import com.entity.Customer;
import com.entity.Deposit;
import com.util.Location;
import com.util.MyFont;

public class DepositInformationDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_bmsid;
	private JTextField jtf_id;
	private JTextField jtf_date;
	private JTextField jtf_money;
	private JTextField jtf_balance;
	
	private JLabel jl_bmsid_1;
	private JLabel jl_id_1;
	private JLabel jl_date_1;
	private JLabel jl_money_1;
	private JLabel jl_balance_1;
	
	Deposit d = new Deposit();
	int flag;
	
	// 测试
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new DepositInformationDialog(new Deposit(), 0, "test"));
		jf.setSize(1000, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
	public DepositInformationDialog(Deposit d, int flag, String s) {
		setForeground(new Color(0, 255, 204));
		this.d = d;
		this.flag = flag;
		setSize(504, 660);		// mark
		this.setTitle("存款单");
		
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel jl_logo = new JLabel("存款单");
			jl_logo.setBackground(new Color(51, 204, 153));
			jl_logo.setHorizontalAlignment(SwingConstants.CENTER);
			jl_logo.setFont(new Font("微软雅黑", Font.BOLD, 30));
			jl_logo.setBounds(167, 10, 199, 43);
			contentPanel.add(jl_logo);
		}
		{
			JLabel jl_bmsid = new JLabel("管理员ID:");
			jl_bmsid.setBounds(83, 74, 79, 30);
			contentPanel.add(jl_bmsid);
		}
		{
			JLabel jl_id = new JLabel("卡号:");
			jl_id.setBounds(83, 127, 79, 30);
			contentPanel.add(jl_id);
		}
		{
			JLabel jl_money = new JLabel("金额:");
			jl_money.setBounds(83, 176, 79, 30);
			contentPanel.add(jl_money);
		}
		
		jtf_bmsid = new JTextField();
		jtf_bmsid.setBounds(172, 74, 180, 30);
		jtf_bmsid.setText(s);
		jtf_bmsid.setEnabled(false);
		contentPanel.add(jtf_bmsid);
		jtf_bmsid.setColumns(10);
		jtf_bmsid.setFont(MyFont.getMyFont());
		
		jl_bmsid_1 = new JLabel("");
		jl_bmsid_1.setBounds(370, 74, 94, 30);
		contentPanel.add(jl_bmsid_1);
		
		JButton jb_submit = new JButton("提交");
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jb_submit.setBounds(188, 550, 108, 30);
		contentPanel.add(jb_submit);
		
		{
			jtf_id= new JTextField();
			jtf_id.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_id.setColumns(10);
			jtf_id.setBounds(172, 127, 180, 30);
			contentPanel.add(jtf_id);
		}
		jl_id_1 = new JLabel("");
		jl_id_1.setBounds(370, 127, 94, 30);
		contentPanel.add(jl_id_1);
		
		{
			jtf_money = new JTextField();
			jtf_money.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_money.setColumns(10);
			jtf_money.setBounds(172, 176, 180, 30);
			contentPanel.add(jtf_money);
		}
		{
			jl_money_1 = new JLabel("");
			jl_money_1.setBounds(370, 176, 94, 30);
			contentPanel.add(jl_money_1);
		}
		
		jb_submit.setFont(MyFont.getMyFont());
		if(flag == 0) {
			jb_submit.setText("提交");
		} 
		
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag == 0) {
					if(!isNull()) {
						JOptionPane.showMessageDialog(DepositInformationDialog.this, "有未输入的值");
						return;
					}
					Deposit de = getDeposit();
					int flag_customer = judge(de.getC_id());
					if(flag_customer == 1) {
						int flag_add = new DepositDao().insertDeposit(de);
						if(flag_add == 1) {
							JOptionPane.showMessageDialog(DepositInformationDialog.this, "提交成功");
							(DepositInformationDialog.this).dispose();
							return;
						} else {
							JOptionPane.showMessageDialog(DepositInformationDialog.this, "提交失败");
							return;
						}
					} else {
						JOptionPane.showMessageDialog(DepositInformationDialog.this, "账号信息错误");
						return;
					}
					
				} else {
					
				}
			}
		});
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		Location.setCenter(this);
	}
	
	public Deposit getDeposit() {
		Deposit c = new Deposit();
		c.setBms_id(jtf_bmsid.getText());
		c.setC_id(jtf_id.getText());
		c.setD_money(Double.parseDouble(jtf_money.getText()));
		
		return c;
	}
	
	public int judge(String id) {
		int flag = 0;
		
		Customer temp = new Customer();
		temp.setC_id(id);
		
		Customer cu = new CustomerDao().selectCustomerWithCID(temp);
		
		if(cu == null) 
			flag = 0;
		else
			flag = 1;
		return flag;
	}
	
	public boolean isNull() {
		String bmsid = jtf_bmsid.getText();
		String cid = jtf_id.getText();
		String money = jtf_money.getText();
		
		if("".equals(cid) || cid == null) {
			return false;
		}
		if("".equals(bmsid) || bmsid == null) {
			return false;
		}
		if("".equals(money) || money == null) {
			return false;
		}
		
		return true;
	}
}
