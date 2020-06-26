package com.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableSetting {
	
	public static void makeFace(JTable table) {
		try {
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					if(row % 2 == 0) {
						setBackground(Color.white);		// 设置奇数行底色
					} else if(row % 2 == 1) {
						setBackground(new Color(206, 231, 255));	// 设置偶数行底色
					}
					return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				}
			};
			
			for(int i = 0; i < table.getColumnCount(); i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
