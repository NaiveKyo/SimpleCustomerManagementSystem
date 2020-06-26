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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.dao.DepositDao;
import com.dao.WithdrawalDao;
import com.entity.Deposit;
import com.entity.Withdrawal;
import com.util.MyFont;
import com.util.TableColums;
import com.util.TableSetting;

public class BusinessWithdrawalPanel extends JPanel implements MouseListener {
		// 测试
		public static void main(String[] args) {
			BusinessWithdrawalPanel a = new BusinessWithdrawalPanel("test");
			JFrame jf = new JFrame();
			jf.add(a);
			jf.setSize(1000, 500);
			jf.setVisible(true);
		}
		
		private JTextField jtf_id;
		private JTable jt_withdrawal;
		private DefaultTableModel dm;
		private DefaultTableColumnModel dcm;
		private JLabel jl_add;
		private JLabel jl_del;
		private JLabel jl_update;
		private JLabel jl_refresh;
		
		private String s;
		
		
		
		public BusinessWithdrawalPanel() {
			
		}

		/**
		 * 将客户信息填入表格
		 * @param customer
		 */
		public void fillTable(Withdrawal withdrawal) {
			dm = (DefaultTableModel) jt_withdrawal.getModel();
			dm.setRowCount(0);
			
			List<Withdrawal> list = new WithdrawalDao().selectWithdrawalList(withdrawal);
			
			for(Withdrawal d : list) {
				Vector<Object> v = new Vector<Object>();
				v.add(d.getBms_id());
				v.add(d.getC_id());
				v.add(d.getW_date());
				v.add(d.getW_money());
				v.add(d.getC_balance());
				
				dm.addRow(v);
			}
		}
		
		/**
		 * 转账信息面板
		 */
		public BusinessWithdrawalPanel(String s) {
			this.s = s;
			setBounds(100, 100, 960, 550);
			setLayout(new BorderLayout(0, 0));
			
			JPanel jp_tool = new JPanel();
			jp_tool.setPreferredSize(new Dimension(1000, 50));
			
			add(jp_tool, BorderLayout.NORTH);
			jp_tool.setLayout(null);
			
			jl_add = new JLabel("处理业务");
			jl_add.setBounds(0, 10, 80, 30);
			jp_tool.add(jl_add);
			jl_add.setFont(MyFont.getMyFont());
			jl_add.setIcon(new ImageIcon("image/add.png"));
			jl_add.addMouseListener(this);
			
			JLabel jl_id = new JLabel("卡号");
			jl_id.setBounds(352, 10, 50, 30);
			jp_tool.add(jl_id);
			jl_id.setFont(MyFont.getMyFont());
			
			jtf_id = new JTextField();
			jtf_id.setBounds(403, 11, 100, 30);
			jp_tool.add(jtf_id);
			jtf_id.setColumns(10);
			jtf_id.setFont(MyFont.getMyFont());
			
			jt_withdrawal = new JTable(new DefaultTableModel(TableColums.getWithdrawalColums(), 0) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
			
			jt_withdrawal.setRowHeight(30);
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			jt_withdrawal.setDefaultRenderer(Object.class, r);
			TableSetting.makeFace(jt_withdrawal);
			
			fillTable(new Withdrawal());
			JScrollPane js = new JScrollPane(jt_withdrawal);
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
				
					String cid = jtf_id.getText().trim();
					
					Withdrawal withdrawal = new Withdrawal();
					withdrawal.setC_id(cid);
					
					fillTable(withdrawal);
				}
			});
		}

		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = jt_withdrawal.getSelectedRow();
			if(e.getSource() == jl_add) {
				Withdrawal wd = new Withdrawal();
				new WithdrawalInformationDialog(wd, 0, s);
			} else if(e.getSource() == jl_refresh) {
				fillTable(new Withdrawal());
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
				jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "处理业务" + "</font></html>");
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
				jl_add.setText("处理业务");
			}else if (e.getSource() == jl_refresh) {
				jl_refresh.setText("刷新");
			} else {
				
			}
		}
}
