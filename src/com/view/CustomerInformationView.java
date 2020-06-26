package com.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.entity.Customer;
import com.util.CommboxData;
import com.util.ImagePanel;
import com.util.MyFont;

public class CustomerInformationView extends ImagePanel {
	private JTextField jtf_cid;
	private JTextField jtf_psw;
	private JTextField jtf_name;
	private JTextField jtf_balance;
	private JTextField jtf_status;
	private JTextField jtf_date;
	private JTextField jtf_identity;
	
	private JComboBox jc_address;
	
	/**
	 * create a panel
	 */
	public CustomerInformationView(int width, int height, Image image, Customer customer) {
		super(width, height, image);
		this.setPreferredSize(new Dimension(1000, 550));
		setLayout(null);
		
		JLabel jl_cid = new JLabel("卡号:");
		jl_cid.setBounds(212, 70, 60, 30);
		add(jl_cid);
		jl_cid.setFont(MyFont.getMyFont());
		
		jtf_cid = new JTextField();
		jtf_cid.setEnabled(false);
		jtf_cid.setBounds(294, 71, 182, 30);
		add(jtf_cid);
		jtf_cid.setColumns(10);
		jtf_cid.setFont(MyFont.getMyFont());
		
		JLabel jl_name = new JLabel("姓名:");
		jl_name.setBounds(549, 70, 60, 30);
		add(jl_name);
		jl_name.setFont(MyFont.getMyFont());
		
		jtf_name = new JTextField();
		jtf_name.setEnabled(false);
		jtf_name.setColumns(10);
		jtf_name.setBounds(625, 71, 182, 30);
		add(jtf_name);
		jtf_name.setFont(MyFont.getMyFont());
		
		JLabel jl_status = new JLabel("状态");
		jl_status.setBounds(212, 151, 82, 30);
		add(jl_status);
		jl_status.setFont(MyFont.getMyFont());
		
		jtf_status = new JTextField();
		jtf_status.setEnabled(false);
		jtf_status.setColumns(10);
		jtf_status.setBounds(294, 151, 182, 30);
		add(jtf_status);
		jtf_status.setFont(MyFont.getMyFont());
		
		JLabel jl_balance = new JLabel("余额:");
		jl_balance.setBounds(549, 151, 82, 30);
		add(jl_balance);
		jl_balance.setFont(MyFont.getMyFont());
		
		jtf_balance = new JTextField();
		jtf_balance.setEnabled(false);
		jtf_balance.setColumns(10);
		jtf_balance.setBounds(625, 152, 182, 30);
		add(jtf_balance);
		jtf_balance.setFont(MyFont.getMyFont());

		JLabel jl_date = new JLabel("日期:");
		jl_date.setBounds(212, 228, 82, 30);
		add(jl_date);
		jl_date.setFont(MyFont.getMyFont());
		
		jtf_date = new JTextField();
		jtf_date.setEnabled(false);
		jtf_date.setColumns(10);
		jtf_date.setBounds(293, 229, 182, 30);
		add(jtf_date);
		jtf_date.setFont(MyFont.getMyFont());
		
		JLabel jl_address = new JLabel("地址:");
		jl_address.setBounds(549, 228, 82, 30);
		add(jl_address);
		jl_address.setFont(MyFont.getMyFont());
		
		jc_address = new JComboBox();
		jc_address.setBounds(625, 229, 182, 30);
		add(jc_address);
		jc_address.setFont(MyFont.getMyFont());
		jc_address.addItem("--请选择--");
		String[] provinces = CommboxData.getProvinces();
		for (String data : provinces) {
			jc_address.addItem(data);
		}
		
		JLabel jl_identity = new JLabel("身份证:");
		jl_identity.setBounds(212, 313, 82, 30);
		add(jl_identity);
		jl_identity.setFont(MyFont.getMyFont());
		
		jtf_identity = new JTextField();
		jtf_identity.setEnabled(false);
		jtf_identity.setColumns(10);
		jtf_identity.setBounds(293, 314, 182, 30);
		add(jtf_identity);
		jtf_identity.setFont(MyFont.getMyFont());
		
		
		setValues(customer);
		setEdit();
	}
	
	public void setEdit() {
		jtf_cid.setEditable(false);
		jtf_balance.setEditable(false);
		jtf_date.setEditable(false);
		jtf_identity.setEditable(false);
		jtf_name.setEditable(false);
		jtf_status.setEditable(false);
		jc_address.setEditable(false);
	}
	
	public void setValues(Customer c) {
		jtf_cid.setText(c.getC_id());
		jtf_name.setText(c.getC_name());
		jtf_status.setText(c.getC_status());
		jtf_balance.setText(String.valueOf(c.getC_balance()));
		jtf_date.setText(c.getC_date());
		jtf_identity.setText(c.getC_identity());
		jc_address.setSelectedItem(c.getC_adress());
	}
}
