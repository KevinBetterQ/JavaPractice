package com.qwk.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Sum {
	
	static JTextArea num1;
	static JTextArea num2 ;
	static JTextArea result;
	
	static JComboBox<String> operator;

	public static void main(String[] args) {
		JFrame frame = new JFrame("简单计算器");
		JPanel jPanel = new JPanel();
		
		Font bigFont1 = new Font("serif", Font.BOLD, 20);
		
		num1 = new JTextArea(2,10);
		num2 = new JTextArea(2,10);
		result = new JTextArea(2,10);
		
		//下拉列表框组件
		String[] signStrings = {"+", "-", "*","/"};
		operator = new JComboBox<>(signStrings);
		operator.setFont(bigFont1);
		JButton jButton = new JButton("=");
		jButton.setFont(bigFont1);
		num1.setFont(bigFont1);
		num2.setFont(bigFont1);
		result.setFont(bigFont1);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String opertorItem = (String) operator.getSelectedItem(); 
				String str_num1 = num1.getText();
				String str_num2 = num2.getText();
				double d_num1 = Double.parseDouble(str_num1);
				double d_num2 = Double.parseDouble(str_num2);
				if(opertorItem.equals("+")){
					double d_result = d_num1 + d_num2;
					String str_result = Double.toString(d_result);
					result.setText("");
					result.setText(str_result);
				}else if (opertorItem.equals("-")) {
					double d_result = d_num1 - d_num2;
					String str_result = Double.toString(d_result);
					result.setText("");
					result.setText(str_result);
				}
				else if (opertorItem.equals("*")) {
					double d_result = d_num1 * d_num2;
					String str_result = Double.toString(d_result);
					result.setText("");
					result.setText(str_result);
				}
				else if (opertorItem.equals("/")) {
					
					if(d_num2 == 0){
						JOptionPane.showMessageDialog(null, "除数不能为零 ", "Sorry ", JOptionPane.ERROR_MESSAGE);
					}else{
						double d_result = d_num1 / d_num2;
						String str_result = Double.toString(d_result);
						result.setText("");
						result.setText(str_result);
					}
					
				}
				
				
				
			}
		});
		
		
		// 面板
		jPanel.add(num1);
		jPanel.add(operator);
		jPanel.add(num2);
		jPanel.add(jButton);
		jPanel.add(result);
		
		
		frame.getContentPane().add(BorderLayout.CENTER, jPanel);
		frame.setSize(600, 120);
		frame.setVisible(true);

	}

}
