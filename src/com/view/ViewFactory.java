package com.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.entity.Admin;
import com.entity.Customer;
import com.util.ImagePanel;

public class ViewFactory {
	
	/**
	 * �����ҳ�ı���ͼƬ
	 * @return
	 */
	@SuppressWarnings("finally")
	public static ImagePanel getIndexBackPanel() {
		ImagePanel imagePanel = null;
		
		try {
			Image image = ImageIO.read(new File("image/login.jpg"));
			imagePanel = new ImagePanel(1000, 550, image);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			return imagePanel;
		}
	}
	
	/**
	 * ����Ա���棺�ͻ�����
	 * @return
	 */
	public static JPanel getCustomerManagerPanel() {
		JPanel jp = new CustomerManagerPanel();
		jp.setSize(1000, 550);
		return jp;
	}
	
	/**
	 * ����Ա���棺ҵ����-���ҵ��
	 * @param s
	 * @return
	 */
	public static JPanel getBusinessDepositPanel(String s) {
		JPanel jp = new BusinessDepositPanel(s);
		jp.setSize(1000, 550);
		return jp;
	}
	
	/**
	 * ����Ա���棺ҵ����-ȡ��ҵ��
	 * @param s
	 * @return
	 */
	public static JPanel getBusinessWithdrawalPanel(String s) {
		JPanel jp = new BusinessWithdrawalPanel(s);
		jp.setSize(1000, 550);
		return jp;
	}
	
	/**
	 * ����Ա���棺ҵ����-ת��ҵ��
	 * @param s
	 * @return
	 */
	public static JPanel getBusinessTransferPanel(String s) {
		JPanel jp = new BusinessTransferPanel(s);
		jp.setSize(1000, 550);
		return jp;
	}
	
	/**
	 * �ͻ����棺�û�����-�û���Ϣ
	 * @param customer
	 * @return
	 */
	@SuppressWarnings("finally")
	public static JPanel getCustomerInformationPanel(Customer customer) {
		JPanel jp = null;
		
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new CustomerInformationView(1050, 550, image, customer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}
	
	/**
	 * �ͻ����棺�û�����-�����޸�
	 * @param customer
	 * @return
	 */
	@SuppressWarnings("finally")
	public static JPanel getCustomerUpdatePswView(Customer customer) {
		JPanel jp = null;
		
		try {
			Image image = ImageIO.read(new File("image/login.jpg"));
			jp = new CustomerUpdatePswView(1050, 550, image, customer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}
	
	/**
	 * �û����棺������Ϣ-�����Ϣ
	 * @param customer
	 * @return
	 */
	public static JPanel getCustomerDepositTradeView(Customer customer) {
		JPanel jp = new CustomerDepositTradeView(customer);
		jp.setSize(1000, 550);
		return jp;
	}

	/**
	 * �û����棺������Ϣ-ȡ����Ϣ
	 * @param customer
	 * @return
	 */
	public static JPanel getCustomerWithdrawalTradeView(Customer customer) {
		JPanel jp = new CustomerWithdrawalTradeView(customer);
		jp.setSize(1000, 550);
		return jp;
	}
	
	/**
	 * �û����棺������Ϣ-ȡ����Ϣ
	 * @param customer
	 * @return
	 */
	public static JPanel getCustomerTransferTradeView(Customer customer) {
		JPanel jp = new CustomerTransferTradeView(customer);
		jp.setSize(1000, 550);
		return jp;
	}
	
	/**
	 * �û����棺������Ϣ-ת����Ϣ
	 * @param customer
	 * @return
	 */
	public static JPanel getCustomerAccountMessageView(Customer customer) {
		JPanel jp = new CustomerAccountMessageView(customer);
		jp.setSize(1000, 550);
		return jp;
	}
}
