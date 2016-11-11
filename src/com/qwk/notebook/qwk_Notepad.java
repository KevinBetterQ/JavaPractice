package com.qwk.notebook;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class qwk_Notepad  {
	private static final long serialVersionUID = 1L;
	JFrame jFrame;
	JMenuBar menubar;
	JMenu wenjian, bianji, bangzhu;
	private TextArea wenjianqu;
	private FileDialog fileload;
	private FileDialog filesave;
	private String file = "";
	EventListener eventlistener = new EventListener();

    public TextArea getJTextArea() {
        return this.wenjianqu;
    }

    public JFrame getJFrame() {
        return this.jFrame;
    }
	
	
	public qwk_Notepad(String title) {
		jFrame = new JFrame(title);
		wenjianqu = new TextArea();// 文本编辑区
		/*Font bigFont1 = new Font("serif", Font.PLAIN, 20);
		wenjianqu.setFont(bigFont1);*/
		jFrame.add(wenjianqu);
		menubar = new JMenuBar();//菜单框
		wenjian = new JMenu("文件");// 文件菜单
		bianji = new JMenu("编辑");// 编辑菜单
		bangzhu = new JMenu("帮助");// 帮助菜单
		// 文件菜单的菜单项
		JMenuItem xinjian = new JMenuItem("新建");
		JMenuItem dakai = new JMenuItem("打开");
		JMenuItem baocun = new JMenuItem("保存");
		JMenuItem lingcunwei = new JMenuItem("另存为");
		JMenuItem tuichu = new JMenuItem("退出");
		// 为文件菜单的菜单项添加监听者
		xinjian.addActionListener(eventlistener);
		dakai.addActionListener(eventlistener);
		baocun.addActionListener(eventlistener);
		lingcunwei.addActionListener(eventlistener);
		tuichu.addActionListener(eventlistener);
		// 文件菜单添加菜单项
		wenjian.add(xinjian);
		wenjian.add(dakai);
		wenjian.add(baocun);
		wenjian.add(lingcunwei);// 分隔符
		wenjian.addSeparator();
		wenjian.add(tuichu);
		JMenuItem qingkong = new JMenuItem("清空");
		JMenuItem chazhao = new JMenuItem("查找");
		JMenuItem tiehuan = new JMenuItem("替换");
		qingkong.addActionListener(eventlistener);
		chazhao.addActionListener(eventlistener);
		tiehuan.addActionListener(eventlistener);
		bianji.add(qingkong);
		bianji.add(chazhao);
		bianji.add(tiehuan);
		// 向菜单条添加菜单
		menubar.add(wenjian);
		menubar.add(bianji);
		menubar.add(bangzhu);
		// 帮助菜单的菜单项
		JMenuItem bangzguzguti = new JMenuItem("帮助");
		JMenuItem aboutme = new JMenuItem("关于");
		// 帮助菜单添加菜单项
		bangzhu.add(bangzguzguti);
		bangzhu.add(aboutme);
		//设置监听
		bangzguzguti.addActionListener(eventlistener);
		aboutme.addActionListener(eventlistener);
		
		fileload = new FileDialog(jFrame, "打开文件", FileDialog.LOAD);
		filesave = new FileDialog(jFrame, "保存文件", FileDialog.SAVE);
		jFrame.setJMenuBar(menubar);
		jFrame.setLocation(250, 200);
		jFrame.setSize(600, 400);
		jFrame.setVisible(true);
		jFrame.setResizable(true);
	}

	class EventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String command = ae.getActionCommand();
			if (command.equals("退出")) {
				jFrame.dispose();
			} else if (command.equals("新建")) {
				newFile();
			} else if (command.equals("打开")) {
				fileload.setVisible(true);
				String direct = fileload.getDirectory();
				String filename = fileload.getFile();
				if ((direct != null) && (filename != null)) {
					file = direct + filename;
					loadFile();
				}
			} else if (command.equals("保存")) {
				saveFile();
			} else if (command.equals("另存为")) {
				saveAs();
			}  else if (command.equals("清空")) {
				qingkongFile();
			}  else if (command.equals("帮助")) {
				JOptionPane.showMessageDialog(null,
						"1.文本编辑\n2.文件打开存储与另存为 \n", "实现功能", JOptionPane.INFORMATION_MESSAGE);
			}  else if (command.equals("关于")) {
				JOptionPane.showMessageDialog(null,
						"作者：亓文凯\n班级：物联网14-1 ", "About me", JOptionPane.INFORMATION_MESSAGE);
			}  else if (command.equals("查找")) {
				Serach serach = new Serach();
			}  else if (command.equals("替换")) {
				Exchange e = new Exchange();
			}
		}
	}

	//打开文件
	public void loadFile() {
		wenjianqu.append("1");
		wenjianqu.setText("");
		jFrame.setTitle("我的记事本---" + file);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String reader = br.readLine();
			while (reader != null) {
				wenjianqu.append(reader + "\n");
				reader = br.readLine();
			}
			br.close();
			
			/*FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			wenjianqu.setText(null);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				wenjianqu.append(line);
			}
			reader.close();*/
			
		} catch (FileNotFoundException e) {
			System.out.println("目标文件：" + file + "找不到！");
			// e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//保存文件
	public void saveFile() {
		String dangqianwenjian = wenjianqu.getText();
		try {
			if (file.isEmpty()) {
				filesave.setVisible(true);
				String direct = filesave.getDirectory();
				String filename = filesave.getFile();
				if ((direct != null) && (filename != null)) {
					file = direct + filename;
					PrintWriter pw = new PrintWriter(new FileWriter(file));
					pw.println(dangqianwenjian);
					pw.flush();
					pw.close();
					jFrame.setTitle("我的记事本---" + file);
				}
			} else {
				PrintWriter pw = new PrintWriter(new FileWriter(file));
				pw.println(dangqianwenjian);
				pw.flush();
				pw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//另存为
	public void saveAs() {
		filesave.setVisible(true);
		String direct = filesave.getDirectory();
		String filename = filesave.getFile();
		if ((direct != null) && (filename != null)) {
			file = direct + filename;
			saveFile();
			jFrame.setTitle("我的记事本---" + file);
		}
	}

	public void qingkongFile() {
		wenjianqu.append("1");
		wenjianqu.setText("");
	}

	public void newFile() {
		new qwk_Notepad("我的记事本---" + "新建文件");
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new qwk_Notepad("我的记事本");
	}

	//查找类
	class Serach implements ActionListener{
		
		JDialog jd;
		JTextField jTextField;
		JButton jButton;
		
		String str_serach = null;
		String stringBuffer = null;
		int i = 0;
		int j=0;
		
		public Serach() {
			jd = new JDialog(jFrame, "查找");
			jTextField = new JTextField(10);
			JButton jb1 = new JButton("查找");
            jb1.addActionListener(this);
            JButton jb2 = new JButton("取消");
            jb2.addActionListener(this);
            JButton jb3 = new JButton("下一个");
            jb3.addActionListener(this);
			JLabel jLabel = new JLabel("查找内容");
			JPanel jp1 = new JPanel(new FlowLayout());
			jp1.add(jLabel);
			jp1.add(jTextField);
			JPanel jp2 = new JPanel(new FlowLayout());
            jp2.add(jb1);
            jp2.add(jb3);
            jp2.add(jb2);
            
            
            jd.setLayout(new GridLayout(2, 1));
            jd.add(jp1);
            jd.add(jp2);
            
            jd.setSize(400, 290);
            Toolkit tk = Toolkit.getDefaultToolkit();
            jd.setLocation((tk.getScreenSize().width - jd.getSize().width) / 2, (tk.getScreenSize().height - jd.getSize().height) / 2);
            jd.setResizable(false);
            jd.setVisible(true);
            jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if ("查找".equals(e.getActionCommand())) {
				str_serach = jTextField.getText();
				stringBuffer = new String(wenjianqu.getText());
				i = stringBuffer.indexOf(str_serach);
				j=j+i;
				if(i < 0){
					javax.swing.JOptionPane.showMessageDialog(jd, "没有查找内容");
				}else{
					wenjianqu.select(i, (str_serach.length()+i));
					j=j+str_serach.length()-1;
					jFrame.setVisible(true);
				}
            }
			if ("取消".equals(e.getActionCommand())) {
                jd.dispose();//关闭对话框；
            }
			if ("下一个".equals(e.getActionCommand())) { 
				
				if(i == 0){
					str_serach = jTextField.getText();
					stringBuffer = new String(wenjianqu.getText());
					i = stringBuffer.indexOf(str_serach);
					j=j+i;
					if(i < 0){
						javax.swing.JOptionPane.showMessageDialog(jd, "没有查找内容");
					}else{
						wenjianqu.select(i, (str_serach.length()+i));
						j=j+str_serach.length()-1;
						jFrame.setVisible(true);
					}
				}else{
					stringBuffer = stringBuffer.substring(i+str_serach.length());
					System.out.println(stringBuffer);
					i = stringBuffer.indexOf(str_serach);
					j=j+i;
					System.out.println(j);
					if(i < 0){
						javax.swing.JOptionPane.showMessageDialog(jd, "查找结束");
					}else{
						wenjianqu.select(j, (str_serach.length()+j));
						j=j+str_serach.length()-1;
						jFrame.setVisible(true);
					}
				}
				
			}
			
		}
		
	}
	//替换类
class Exchange implements ActionListener {

        JDialog jd;
        JTextField jf1;
        JTextField jf2;
        TextArea jta;

        public Exchange() {
            jd = new JDialog(jFrame, "替换");
            jta = wenjianqu;

            jf1 = new JTextField(10);
            jf2 = new JTextField(10);

            JLabel jl1 = new JLabel("被替换对象：");
            JLabel jl2 = new JLabel("替换内容：");

            JButton jb1 = new JButton("确定");
            jb1.addActionListener(this);
            JButton jb2 = new JButton("取消");
            jb2.addActionListener(this);

            JPanel jp1 = new JPanel(new FlowLayout());
            jp1.add(jl1);
            jp1.add(jf1);//替换内容

            JPanel jp3 = new JPanel(new FlowLayout());
            jp3.add(jl2);
            jp3.add(jf2);//替换对象

            JPanel jp2 = new JPanel(new FlowLayout());
            jp2.add(jb1);
            jp2.add(jb2);

            
            jd.setLayout(new GridLayout(3, 1));
            jd.add(jp1);
            jd.add(jp3);
            jd.add(jp2);
            

            jd.setSize(400, 290);
            Toolkit tk = Toolkit.getDefaultToolkit();
            jd.setLocation((tk.getScreenSize().width - jd.getSize().width) / 2, (tk.getScreenSize().height - jd.getSize().height) / 2);
            jd.setResizable(false);
            jd.setVisible(true);
            jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }

        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            if ("确定".equals(e.getActionCommand())) {
                String str = jf1.getText();
                String str1 = jf2.getText();
                String str2 = new String(jta.getText());
                str2 = str2.replaceAll(str, str1);
                jta.setText(str2);
                javax.swing.JOptionPane.showMessageDialog(jd, "替换完成");
            }
            if ("取消".equals(e.getActionCommand())) {
                jd.dispose();//关闭对话框；
            }
        }
    }


}
