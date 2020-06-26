package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.dao.CustomerDao;
import com.entity.Customer;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TableColums;
import com.util.TableSetting;

public class CustomerManagerPanel extends JPanel implements MouseListener {

	// 测试
	public static void main(String[] args) {
		CustomerManagerPanel a = new CustomerManagerPanel();
		JFrame jf = new JFrame();
		jf.add(a);
		jf.setSize(1000, 500);
		jf.setVisible(true);
	}
	
	private JTextField jtf_name;
	private JTextField jtf_id;
	private JTable jt_customer;
	private DefaultTableModel dm;
	private DefaultTableColumnModel dcm;
	private JLabel jl_add;
	private JLabel jl_del;
	private JLabel jl_update;
	private JLabel jl_refresh;
	
	/**
	 * 将客户信息填入表格
	 * @param customer
	 */
	public void fillTable(Customer customer) {
		dm = (DefaultTableModel) jt_customer.getModel();
		dm.setRowCount(0);
		
		List<Customer> list = new CustomerDao().selectCustomerList(customer);
		
		for(Customer c : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(c.getC_id());
			v.add(c.getC_pswd());
			v.add(c.getC_name());
			v.add(c.getC_balance());
			v.add(c.getC_status());
			v.add(c.getC_date());
			v.add(c.getC_adress());
			v.add(c.getC_identity());
			
			dm.addRow(v);
		}
	}
	
	/**
	 * 客户信息管理面板
	 */
	public CustomerManagerPanel() {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel jp_tool = new JPanel();
		jp_tool.setPreferredSize(new Dimension(1000, 50));
		
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setLayout(null);
		
		jl_add = new JLabel("添加");
		jl_add.setBounds(0, 10, 54, 30);
		jp_tool.add(jl_add);
		jl_add.setFont(MyFont.getMyFont());
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);
		
		jl_del = new JLabel("删除");
		jl_del.setBounds(64, 10, 54, 30);
		jp_tool.add(jl_del);
		jl_del.setFont(MyFont.getMyFont());
		jl_del.setIcon(new ImageIcon("image/delete.png"));
		jl_del.addMouseListener(this);
		
		jl_update = new JLabel("修改");
		jl_update.setBounds(128, 10, 54, 30);
		jp_tool.add(jl_update);
		jl_update.setFont(MyFont.getMyFont());
		jl_update.setIcon(new ImageIcon("image/update.png"));
		jl_update.addMouseListener(this);
		
		JLabel jl_name = new JLabel("姓名");
		jl_name.setBounds(352, 10, 50, 30);
		jp_tool.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());
		
		jtf_name = new JTextField();
		jtf_name.setBounds(399, 11, 100, 30);
		jp_tool.add(jtf_name);
		jtf_name.setColumns(10);
		jtf_name.setFont(MyFont.getMyFont());
		
		JLabel jl_id = new JLabel("卡号");
		jl_id.setBounds(521,10, 50, 30);
		jp_tool.add(jl_id);
		jl_id.setFont(MyFont.getMyFont());
		
		jtf_id = new JTextField();
		jtf_id.setBounds(572, 11, 100, 30);
		jp_tool.add(jtf_id);
		jtf_id.setColumns(10);
		jtf_id.setFont(MyFont.getMyFont());
		
		JLabel jl_place = new JLabel("籍贯");
		jl_place.setBounds(700, 10, 50, 30);
		jp_tool.add(jl_place);
		jl_place.setFont(MyFont.getMyFont());
		
		JComboBox jc_place = new JComboBox();
		jc_place.setBounds(750, 10, 100, 30);
		jp_tool.add(jc_place);
		jc_place.setFont(MyFont.getMyFont());
		jc_place.addItem("--请选择--");
		String[] provinces = CommboxData.getProvinces();
		for(String data : provinces) {
			jc_place.addItem(data);
		}
		
		jt_customer = new JTable(new DefaultTableModel(TableColums.getCustomerColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		
		jt_customer.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_customer.setDefaultRenderer(Object.class, r);
		TableSetting.makeFace(jt_customer);
		
		fillTable(new Customer());
		JScrollPane js = new JScrollPane(jt_customer);
		this.add(js, BorderLayout.CENTER);
		
		JButton jb_submit = new JButton("查询");
		jb_submit.setBounds(890, 10, 80, 30);
		jp_tool.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());
		
		jl_refresh = new JLabel("刷新");
		jl_refresh.setFont(MyFont.getMyFont());
		jl_refresh.setBounds(199, 10, 54, 30);
		jp_tool.add(jl_refresh);
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.addMouseListener(this);
		
		jb_submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String cname = jtf_name.getText().trim();
				String cid = jtf_id.getText().trim();
				String provinces = ((String) jc_place.getSelectedItem()).trim();
				
				Customer customer = new Customer();
				customer.setC_name(cname);
				customer.setC_id(cid);
				if(!("--请选择--").equals(provinces))
					customer.setC_adress(provinces);
				
				fillTable(customer);
			}
		});
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = jt_customer.getSelectedRow();
		if(e.getSource() == jl_add) {
			Customer cs = new Customer();
			new CustomerInformationDialog(cs, 0);
		} else if(e.getSource() == jl_del && row >= 0) {
			Customer cs = new Customer();
			cs.setC_id((String) jt_customer.getValueAt(row, 0));
			Customer c = new CustomerDao().selectCustomerWithCID(cs);
			new CustomerInformationDialog(c, 1);
		} else if(e.getSource() == jl_update && row >= 0) {
			Customer cs = new Customer();
			cs.setC_id((String) jt_customer.getValueAt(row, 0));
			Customer c = new CustomerDao().selectCustomerWithCID(cs);
			new CustomerInformationDialog(c, 2);
		} else if(e.getSource() == jl_refresh) {
			fillTable(new Customer());
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
		if (e.getSource() == jl_add) {
			jl_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "添加" + "</font></html>");
		} else if (e.getSource() == jl_del) {
			jl_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_del.setText("<html><font color='#336699' style='font-weight:bold'>" + "删除" + "</font></html>");
		} else if (e.getSource() == jl_update) {
			jl_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_update.setText("<html><font color='#336699' style='font-weight:bold'>" + "修改" + "</font></html>");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "刷新" + "</font></html>");
		} else {
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("添加");
		} else if (e.getSource() == jl_del) {
			jl_del.setText("删除");
		} else if (e.getSource() == jl_update) {
			jl_update.setText("修改");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setText("刷新");
		} else {
			
		}
		
	}
}
