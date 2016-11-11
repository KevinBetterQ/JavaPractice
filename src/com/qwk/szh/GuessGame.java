package com.qwk.szh;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GuessGame {
	
	static int num;
	static JTextField jTextField;
	static JLabel jL_time;//��ʾ�÷���
	static long startTime;
	static long endTime;

	public static void main(String[] args) {
		JFrame jFrame = new JFrame("��������Ϸ");
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		JButton jButton = new JButton("���������");
		final JLabel jLb1 = new JLabel("�����δ����");
		JButton jBt1 = new JButton("  ��ʾ��   ");
		JButton jBt_queding = new JButton("ȷ��");
		JLabel jLabel = new JLabel("�²�����:");
		jTextField = new JTextField(10);
		jL_time = new JLabel("��ʱ��");
		
		Font bigFont1 = new Font("serif", Font.BOLD, 20);
		
		jButton.setFont(bigFont1);
		jLabel.setFont(bigFont1);
		jTextField.setFont(bigFont1);
		jBt_queding.setFont(bigFont1);
		jLb1.setFont(bigFont1);
		jBt1.setFont(bigFont1);
		jL_time.setFont(bigFont1);
		
		jPanel1.add(jButton);
		jPanel2.add(jLb1);
		jPanel2.add(jBt1);
		jPanel2.add(jLabel);
		jPanel2.add(jTextField);
		jPanel2.add(jBt_queding);
		jPanel3.add(jL_time);
		
		jFrame.add(jPanel1);
		jFrame.add(jPanel2);
		jFrame.add(jPanel3);
		jFrame.getContentPane().add(BorderLayout.NORTH, jPanel1);
		jFrame.getContentPane().add(BorderLayout.CENTER, jPanel2);
		jFrame.getContentPane().add(BorderLayout.SOUTH, jPanel3);
		
		
		jFrame.setSize(240, 600);
		jFrame.setVisible(true);
	
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startTime = System.currentTimeMillis();
				num = (int) (Math.random()*10+0.5);
				jLb1.setText("������Ѳ���");
			}
		});
		
		jBt_queding.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String n_str = jTextField.getText();
				int n = Integer.parseInt(n_str);
				if(n == num){
					JOptionPane.showMessageDialog(null, "�ش���ȷ", "��ϲ", JOptionPane.INFORMATION_MESSAGE);
					endTime = System.currentTimeMillis();
					float seconds = (endTime - startTime) / 1000F;
			        jL_time.setText("��ʱ��" + Float.toString(seconds) + " ��");
				}else {
					JOptionPane.showMessageDialog(null, "�ش�������������� ", "Sorry ", JOptionPane.ERROR_MESSAGE);
					jTextField.setText(null);
				}
				
			}
		});
		
		jBt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jLb1.setText(String.valueOf(num));
				
			}
		});
		
		
		

	}

}
