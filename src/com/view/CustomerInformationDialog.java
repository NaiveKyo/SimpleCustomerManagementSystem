package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.util.CommboxData;
import com.util.Location;
import com.util.MyFont;

/**
 * 
 * @author NaiveKyo
 * 开户信息
 */
public class CustomerInformationDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_id;
	private JTextField jtf_psw;
	private JTextField jtf_name;
	private JTextField jtf_status;
	private JTextField jtf_date;
	private JComboBox jc_address;
	private JTextField jtf_identity;
	
	private JLabel jl_id_1;
	private JLabel jl_psw_1;
	private JLabel jl_name_1;
	private JLabel jl_status_1;
	private JLabel jl_date_1;
	private JLabel jl_address_1;
	private JLabel jl_identity_1;
	
	Customer c;
	int flag;

	/**
	 * 构造器
	 * @param c
	 * @param flag
	 */
	public CustomerInformationDialog(Customer c, int flag) {
		setForeground(new Color(0, 255, 204));
		this.c = c;
		this.flag = flag;
		setSize(504, 660);		// mark
		this.setTitle("客户信息");
		
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel jl_logo = new JLabel("客户基本信息");
			jl_logo.setBackground(new Color(51, 204, 153));
			jl_logo.setHorizontalAlignment(SwingConstants.CENTER);
			jl_logo.setFont(new Font("微软雅黑", Font.BOLD, 30));
			jl_logo.setBounds(167, 10, 199, 43);
			contentPanel.add(jl_logo);	
		}
		{
			JLabel jl_id = new JLabel("卡号:");
			jl_id.setBounds(83, 74, 79, 30);
			contentPanel.add(jl_id);
		}
		{
			JLabel jl_psw = new JLabel("密码:");
			jl_psw.setBounds(83, 127, 79, 30);
			contentPanel.add(jl_psw);
		}
		{
			JLabel jl_name = new JLabel("姓名:");
			jl_name.setBounds(83, 176, 79, 30);
			contentPanel.add(jl_name);
		}
		{
			JLabel jl_status = new JLabel("状态:");
			jl_status.setBounds(83, 216, 65, 30);
			contentPanel.add(jl_status);
		}
		{
			JLabel jl_date = new JLabel("日期:");
			jl_date.setBounds(83, 264, 65, 30);
			contentPanel.add(jl_date);
		}
		{
			JLabel jl_adress = new JLabel("籍贯:");
			jl_adress.setBounds(83, 314, 79, 30);
			contentPanel.add(jl_adress);
		}
		{
			JLabel jl_identity = new JLabel("身份证号:");
			jl_identity.setBounds(83, 365, 79, 30);
			contentPanel.add(jl_identity);
		}
		
		jtf_id = new JTextField();
		jtf_id.setBounds(172, 74, 180, 30);
		contentPanel.add(jtf_id);
		jtf_id.setColumns(10);
		jtf_id.setFont(MyFont.getMyFont());
		
		jl_id_1 = new JLabel("");
		jl_id_1.setBounds(370, 74, 94, 30);
		contentPanel.add(jl_id_1);
		
		jtf_id.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				String cid = jtf_id.getText();
				
				Customer c = new Customer();
				c.setC_id(cid);
				Customer s = new CustomerDao().selectCustomerWithCID(c);
				if (s != null) {
					jl_id_1.setIcon(new ImageIcon("image/no.png"));
					jl_id_1.setText("卡号已存在");
					return;
				}
				jl_id_1.setIcon(new ImageIcon("image/yes.png"));
				jl_id_1.setText("");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton jb_submit = new JButton("注册");
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jb_submit.setBounds(188, 550, 108, 30);
		contentPanel.add(jb_submit);
		
		{
			jtf_psw= new JTextField();
			jtf_psw.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_psw.setColumns(10);
			jtf_psw.setBounds(172, 127, 180, 30);
			contentPanel.add(jtf_psw);
		}
		jl_psw_1 = new JLabel("");
		jl_psw_1.setBounds(370, 127, 94, 30);
		contentPanel.add(jl_psw_1);
		
		{
			jtf_name = new JTextField();
			jtf_name.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_name.setColumns(10);
			jtf_name.setBounds(172, 176, 180, 30);
			contentPanel.add(jtf_name);
		}
		{
			jl_name_1 = new JLabel("");
			jl_name_1.setBounds(370, 176, 94, 30);
			contentPanel.add(jl_name_1);
		}
		
		
		{
			jtf_status = new JTextField();
			jtf_status.setFont(new Font("微软雅黑", Font.PLAIN, 14));

			jtf_status.setColumns(10);
			jtf_status.setBounds(172, 216, 180, 30);
			contentPanel.add(jtf_status);
		}
		{
			jl_status_1 = new JLabel("");
			jl_status_1.setBounds(370, 216, 94, 30);
			contentPanel.add(jl_status_1);
		}
		
		
		{
			jtf_date = new JTextField();
			jtf_date.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_date.setColumns(10);
			jtf_date.setBounds(172, 264, 180, 30);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			jtf_date.setText(formatter.format(date));
			jtf_date.setEditable(false);
			contentPanel.add(jtf_date);
		}
		{
			jl_date_1 = new JLabel("");
			jl_date_1.setBounds(370, 264, 94, 30);
			contentPanel.add(jl_date_1);
		}
		
		
		{
			jc_address = new JComboBox();
			jc_address.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jc_address.setBounds(172, 314, 180, 30);
			jc_address.setFont(MyFont.getMyFont());
			jc_address.addItem("--请选择--");
			String[] provinces = CommboxData.getProvinces();
			for(String data : provinces) {
				jc_address.addItem(data);
			}
			contentPanel.add(jc_address);
		}
		{
			jl_address_1 = new JLabel("");
			jl_address_1.setBounds(370, 314, 94, 30);
			contentPanel.add(jl_address_1);
		}
		
		
		{
			jtf_identity = new JTextField();
			jtf_identity.setBounds(172, 365, 180, 30);
			jtf_identity.setFont(MyFont.getMyFont());
			contentPanel.add(jtf_identity);
		}
		{
			jl_identity_1 = new JLabel("");
			jl_identity_1.setBounds(370, 365, 94, 30);
			contentPanel.add(jl_identity_1);
		}
		
		jb_submit.setFont(MyFont.getMyFont());
		if(flag == 0) {
			jb_submit.setText("添加");
		} else if(flag == 1) {
			jb_submit.setText("删除");
			setCustomer(c);
			setEdit();
		} else if(flag == 2) {
			jb_submit.setText("修改");
			setCustomer(c);
			jtf_id.setEnabled(false);
			jtf_date.setEnabled(false);
			jc_address.setEnabled(false);
			jtf_identity.setEnabled(false);
			jtf_name.setEnabled(false);
		}
		
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag == 0) {
					if(!isNull()) {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "有未输入的值");
						return;
					}
					Customer cs = getCustomer();
					int flag_add = new CustomerDao().insertCustomer(cs);
					if(flag_add == 1) {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "添加成功");
						(CustomerInformationDialog.this).dispose();
						return;
					} else {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "添加失败");
						return;
					}
				} else if(flag == 1) {
					int flag_del = new CustomerDao().delCustomer(c);
					if(flag_del == 0) {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "删除失败");
						return;
					} else {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "删除成功");
						(CustomerInformationDialog.this).dispose();
						return;
					}
				} else if(flag == 2) {
					Customer cs = getCustomer();
					if(!isNull()) {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "有未输入的值");
						return;
					}
					
					int flag_update = new CustomerDao().updateCustomer(cs);
					if(flag_update == 0) {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(CustomerInformationDialog.this, "修改成功");
						(CustomerInformationDialog.this).dispose();
						return;
					}
				} else {
					System.out.println("无此操作");
				}
			}
		});
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		Location.setCenter(this);
	}
	
	public void setCustomer(Customer c) {
		jtf_id.setText(c.getC_id());
		jtf_psw.setText(c.getC_pswd());
		jtf_name.setText(c.getC_name());
		jtf_status.setText(c.getC_status());
		jtf_date.setText(c.getC_date());
		jc_address.setSelectedItem(c.getC_adress());
		jtf_identity.setText(c.getC_identity());
	}
	
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setC_id(jtf_id.getText());
		c.setC_pswd(jtf_psw.getText());
		c.setC_name(jtf_name.getText());
		c.setC_status(jtf_status.getText());
		c.setC_adress((String)jc_address.getSelectedItem());
		c.setC_identity(jtf_identity.getText());
		
		return c;
	}
	
	public void setEdit() {
		jtf_id.setEnabled(false);
		jtf_psw.setEditable(false);
		jtf_name.setEditable(false);
		jtf_status.setEditable(false);
		jtf_date.setEditable(false);
		jc_address.setEnabled(false);
		jtf_identity.setEditable(false);
	}
	
	public boolean isNull() {
		String cid = jtf_id.getText();
		String cpsw = jtf_psw.getText();
		String name = jtf_name.getText();
		String status = jtf_status.getText();
		String date = jtf_date.getText();
		String address = (String)jc_address.getSelectedItem();
		String identity = jtf_identity.getText();
		
		if("".equals(cid) || cid == null) {
			return false;
		}
		if("".equals(cpsw) || cpsw == null) {
			return false;
		}
		if("".equals(name) || name == null) {
			return false;
		}
		if("".equals(status) || status == null) {
			return false;
		}
		if("".equals(date) || date == null) {
			return false;
		}
		if("".equals(address) || address == null) {
			return false;
		}
		if("".equals(identity) || identity == null) {
			return false;
		}
		
		return true;
	}
}
