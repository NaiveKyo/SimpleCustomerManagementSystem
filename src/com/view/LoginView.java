package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.entity.Admin;
import com.entity.Customer;
import com.util.Location;
import com.util.MyFont;

/**
 * 
 * @author NaiveKyo
 * ��¼����
 */
public class LoginView extends JFrame {
	
	private JPanel contentPane;
	private JTextField jtf_user;
	private JPasswordField jpf_psw;
	private JComboBox<Object> jb_role;
	
	/**
	 * �޲ι�����
	 */
	public LoginView() {
		
		this.setTitle("���пͻ�����ϵͳ");
		this.setLocationRelativeTo(null);
		this.setSize(800, 500);
		
		Location.setCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jl_back = new JLabel(new ImageIcon("image/login_001.jpg"));	// ���õ�¼����ͼ
		jl_back.setBounds(0, 0, 800, 500);
		this.getLayeredPane().add(jl_back, new Integer(Integer.MIN_VALUE));
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JPanel jp_back = new JPanel();
		jp_back.setBounds(235, 81, 355, 270);
		contentPane.add(jp_back);
		jp_back.setLayout(null);
		jp_back.setOpaque(false);
		
		JLabel jl_role = new JLabel("��    ɫ");
		jl_role.setBounds(27, 84, 67, 18);
		jp_back.add(jl_role);
		jl_role.setFont(MyFont.getMyFont());
		
		JLabel jl_user = new JLabel("�û���");
		jl_user.setBounds(27, 128, 67, 18);
		jp_back.add(jl_user);
		jl_user.setFont(MyFont.getMyFont());
		
		JLabel jl_psw = new JLabel("��   ��");
		jl_psw.setBounds(27, 181, 67, 18);
		jp_back.add(jl_psw);
		jl_psw.setFont(MyFont.getMyFont());
		
		jtf_user = new JTextField();
		jtf_user.setBounds(106, 122, 192, 30);
		jp_back.add(jtf_user);
		jtf_user.setColumns(20);
		jtf_user.setFont(MyFont.getMyFont());
		
		jb_role = new JComboBox<Object>();
		jb_role.setModel(new DefaultComboBoxModel<Object>(new String[] {
				"����Ա", "�û�"
		}));
		jb_role.setBounds(106, 79, 192, 28);
		jb_role.setFont(MyFont.getMyFont());
		
		jp_back.add(jb_role);
		
		jpf_psw = new JPasswordField();
		jpf_psw.setBounds(106, 175, 192, 30);
		jpf_psw.setFont(MyFont.getMyFont());
//		jpf_psw.setEchoChar('��');
		
		jp_back.add(jpf_psw);
		
		// ����Ĭ�ϵ�¼�˺�
		jtf_user.setText("���Թ���Ա1");
		jpf_psw.setText("123456");
		
		JButton jb_login = new JButton("��¼");
		// jb_login.setBackground(Color.DARK_GRAY);
		jb_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String user = jtf_user.getText().trim();
				String psw = String.valueOf(jpf_psw.getPassword()).trim();
				String select = (String)jb_role.getSelectedItem();
				
//				System.out.println(user + " " + psw + " " + select);
				
				if("����Ա".equals(select)) {
					Admin admin = new AdminDao().selectAdminWithPSW(new Admin(user, psw));
					if(admin != null) {
						LoginView.this.dispose();
						new IndexView(admin);
					} else {
						JOptionPane.showMessageDialog(LoginView.this, new JLabel("<html><font size=5>�û����������������</font></html>"));
					}
				} else {
					Customer customer = new CustomerDao().selectCustomer(new Customer(user, psw));
					if(customer != null) {
						LoginView.this.dispose();
						new IndexView(customer);
					} else {
						JOptionPane.showMessageDialog(LoginView.this, new JLabel("<html><font size=5>�û����������������</font></html>"));
					}
				}
			}
		});
		
		jb_login.setBounds(106, 217, 90, 30);
		jb_login.setFont(MyFont.getMyFont());
		jp_back.add(jb_login);
		
		JButton jb_register = new JButton("ע��");
		jb_register.setBounds(208, 217, 90, 30);
		jb_register.setFont(MyFont.getMyFont());
		jp_back.add(jb_register);
		
		jb_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LoginView.this.dispose();
				new RegisterView();
			}
		});
	}
}
