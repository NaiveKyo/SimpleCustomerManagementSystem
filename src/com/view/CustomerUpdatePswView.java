package com.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.main.BankSystem;
import com.util.ImagePanel;
import com.util.MyFont;

public class CustomerUpdatePswView extends ImagePanel {
	
	private JTextField jtf_id;
	private JPasswordField jtf_psw;
	private JPasswordField jtf_again;
	
	/**
	 * create a panel
	 * @param width
	 * @param height
	 * @param image
	 * @param customer
	 */
	public CustomerUpdatePswView(int width, int height, Image image, Customer customer) {
		super(width, height, image);
		this.setPreferredSize(new Dimension(1000, 550));
		setLayout(null);
		
		JPanel jp_back = new JPanel();
		jp_back.setBounds(343, 123, 379, 282);
		add(jp_back);
		jp_back.setLayout(null);
		
		JLabel jl_id = new JLabel("姓  名:");
		jl_id.setBounds(53, 29, 65, 30);
		jp_back.add(jl_id);
		jl_id.setFont(MyFont.getMyFont());
		
		JLabel jl_psw = new JLabel("输入密码:");
		jl_psw.setBounds(53, 97, 65, 30);
		jp_back.add(jl_psw);
		jl_psw.setFont(MyFont.getMyFont());
		
		JLabel jl_again = new JLabel("重新输入:");
		jl_again.setBounds(53, 160, 65, 30);
		jp_back.add(jl_again);
		jl_again.setFont(MyFont.getMyFont());
		
		JButton jb_submit = new JButton("提交");
		jb_submit.setBounds(141, 212, 100, 30);
		jp_back.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());
		
		jtf_id = new JTextField();
		jtf_id.setBounds(141, 30, 157, 30);
		jp_back.add(jtf_id);
		jtf_id.setColumns(10);
		jtf_id.setFont(MyFont.getMyFont());
		jtf_id.setText(customer.getC_id());
		jtf_id.setEditable(false);
		
		jtf_psw = new JPasswordField();
		jtf_psw.setBounds(141, 97, 157, 30);
		jp_back.add(jtf_psw);
		jtf_psw.setFont(MyFont.getMyFont());
		
		jtf_again = new JPasswordField();
		jtf_again.setFont(MyFont.getMyFont());
		jtf_again.setBounds(141, 160, 157, 30);
		jp_back.add(jtf_again);
		
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				String cid = jtf_id.getText();
				String psw = String.valueOf(jtf_psw.getPassword());
				String again = String.valueOf(jtf_again.getPassword());
				
				if(!psw.equals(again)) {
					JOptionPane.showMessageDialog(CustomerUpdatePswView.this, "两次输入的密码不一致");
					return;
				}
				
				if("".equals(psw)) {
					JOptionPane.showMessageDialog(CustomerUpdatePswView.this, "密码不能为空");
					return;
				}
				String inputValue = JOptionPane.showInputDialog("请输入新的密码：");
				Customer c = new CustomerDao().selectCustomer(new Customer(cid, psw));
				
				if(c == null) {
					JOptionPane.showMessageDialog(CustomerUpdatePswView.this, "密码错误，请重新输入");
					return;
				} else {
					c.setC_pswd(inputValue);
					int flag = new CustomerDao().updateCustomerPSW(c);
					if(flag == 0) {
						JOptionPane.showMessageDialog(CustomerUpdatePswView.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(CustomerUpdatePswView.this, "修改成功,请重新登录");
						JOptionPane.getFrameForComponent(CustomerUpdatePswView.this).dispose();
						BankSystem.main(null);
						return;
					}
				}
			}
		});
	}
}
