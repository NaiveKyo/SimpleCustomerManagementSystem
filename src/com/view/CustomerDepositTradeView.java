package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.dao.DepositDao;
import com.entity.Customer;
import com.entity.Deposit;
import com.util.MyFont;
import com.util.TableColums;
import com.util.TableSetting;

public class CustomerDepositTradeView extends JPanel implements MouseListener {
	
	private DefaultTableModel dm;
	private DefaultTableColumnModel dcm;
	private JTable jt_deposit;
	
	private JLabel jl_refresh;
	private String cid;
	
	/**
	 * 
	 */
	public CustomerDepositTradeView() {
		super();
	}
	
	public void fillTable(Deposit deposit) {
		dm = (DefaultTableModel) jt_deposit.getModel();
		dm.setRowCount(0);
		
		List<Deposit> list = new DepositDao().selectDepositList(deposit);
		
		for(Deposit d : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(d.getBms_id());
			v.add(d.getC_id());
			v.add(d.getD_date());
			v.add(d.getD_money());
			v.add(d.getC_balance());
			
			dm.addRow(v);
		}
	}

	/**
	 * 
	 * @param customer
	 */
	public CustomerDepositTradeView(Customer customer) {
		setBounds(100, 100, 960, 550);
		setLayout(new BorderLayout(0, 0));
		this.cid = customer.getC_id();
		
		JPanel jp_tool = new JPanel();
		jp_tool.setPreferredSize(new Dimension(1000, 50));
		
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setLayout(null);
		
		jl_refresh = new JLabel("Ë¢ÐÂ");
		jl_refresh.setFont(MyFont.getMyFont());
		jl_refresh.setBounds(890, 10, 54, 30);
		jp_tool.add(jl_refresh);
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.addMouseListener(this);
		
		jt_deposit = new JTable(new DefaultTableModel(TableColums.getDepositColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		
		jt_deposit.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_deposit.setDefaultRenderer(Object.class, r);
		TableSetting.makeFace(jt_deposit);
		
		fillTable(new Deposit(cid));
		JScrollPane js = new JScrollPane(jt_deposit);
		this.add(js, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt_deposit.getSelectedRow();
		if(e.getSource() == jl_refresh) {
			fillTable(new Deposit(cid));
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
		if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "Ë¢ÐÂ" + "</font></html>");
		} 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_refresh) {
			jl_refresh.setText("Ë¢ÐÂ");
		} 
	}
}
