package com.qwk.notebook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.filechooser.FileSystemView;



import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * 记事本开�?
 * @author janksenhu
 */
public class NoteBook implements ActionListener {

    JFrame jf;
    JTextArea jta;
    JMenuItem[][] jmi;
    myStack ms = new myStack();

    public NoteBook() {
        jf = new JFrame("记事�?");

        JMenuBar jmb = new JMenuBar();

        jta = new JTextArea();
        jf.add(jta);
        ms.push(jta.getText());

        JScrollPane jsp = new JScrollPane(jta);
        jf.add(jsp);

        String[] str1 = {"文件", "编辑", "格式", "帮助"};
        String[][] str2 = {{"新建", "打开", "保存", "另存", "", "页面设置", "打印", "", "�?�?"},
        {"撤销", "", "剪贴", "拷贝", "粘贴", "", "查找", "替换", "删除", "时间"},
        {"字体"},
        {"帮助主题", "关于记事�?"}};

        JMenu[] jm = new JMenu[str1.length];
//   jmi=new JMenuItem[str1.length][];//注意在这里定义有空指针异常！

        for (int i = 0; i < str1.length; i++) {
            jm[i] = new JMenu(str1[i]);
            jmb.add(jm[i]);
        }

        for (int i = 0; i < str1.length; i++) {
            jmi = new JMenuItem[str1.length][str2[i].length];
            for (int j = 0; j < str2[i].length; j++) {
                if ("".equals(str2[i][j])) {
                    jm[i].addSeparator();//添加分割线�??
                } else {
                    jmi[i][j] = new JMenuItem(str2[i][j]);
                    jm[i].add(jmi[i][j]);
                    jmi[i][j].addActionListener(this);
                }
            }
        }

        jf.add(jmb, BorderLayout.NORTH);//注意�?要注明其放的位置，不然会在左�?

        jf.setVisible(true);
        jf.pack();
        Toolkit tk = Toolkit.getDefaultToolkit();
        jf.setLocation((tk.getScreenSize().width - jf.getSize().width) / 2, (tk.getScreenSize().height - jf.getSize().height) / 2);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextArea getJTextArea() {
        return this.jta;
    }

    public JFrame getJFrame() {
        return this.jf;
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String str = e.getActionCommand();
        if ("新建".equals(str)) {
            new NoteBook();

        } else if ("打开".equals(str)) {

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);//注意在这里的null表示对话框弹出的位置�?
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectfile = jfc.getSelectedFile();
                try {
                    FileReader reader = new FileReader(selectfile);
                    Scanner sc = new Scanner(reader);
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        jta.setText(line);
                    }

                    try {
                        reader.close();//////////////////////阅读器需要关闭吗�?///////////////////
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if (jfc.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
                ///////////////////////处理/////////////////////////////
                javax.swing.JOptionPane.showMessageDialog(jfc, "你已经取消了");
            }

        } else if ("保存".equals(str)) {
            JFileChooser jfc = new JFileChooser();
            jfc.showSaveDialog(null);//注意在这里的null表示对话框弹出的位置�?
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectfile = jfc.getSelectedFile();
                try {
                    PrintWriter pw = new PrintWriter(selectfile);//�?文件里写
                    pw.print(jta.getText());
                    pw.close();//关闭///////////////////////////////////////////
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if (jfc.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
                ///////////////////////////////////添加//////////////////////////
                javax.swing.JOptionPane.showMessageDialog(jfc, "你已经取消了");
            }

        } else if ("另存".equals(str)) {
            JOptionPane jop = new JOptionPane();
            String filePath = jop.showInputDialog("请输入路径（型如C:/save.txt�?");//直接返回的是用户输入的信息！
//    jop.getInputValue();//注意这种的到用户的输入是不对的；
            String str2 = "^[cdefCDEF]:/[A-Za-Z0-9]{1,}.txt$";//路径正则表达式；
            System.out.println(filePath);
            if (filePath.matches(str2)) {//特别注意了政则表达式在后�?
                javax.swing.JOptionPane.showMessageDialog(jop, "文件路径真确");
            } else {
                javax.swing.JOptionPane.showMessageDialog(jop, "文件路径不对");
            }
            PrintWriter pw;
            try {
                pw = new PrintWriter(filePath);
                pw.print(jta.getText());
                pw.close();//关闭////////////////////////// 
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }//�?文件里写

        } else if ("页面设置".equals(str)) {
            javax.swing.JOptionPane.showMessageDialog(jf, "没有打印�?");
        } else if ("打印".equals(str)) {
            javax.swing.JOptionPane.showMessageDialog(jf, "没有打印�?");
        } else if ("�?�?".equals(str)) {
            jf.dispose();//注意这是�?�?
        } else if ("撤销".equals(str)) {
            String str5 = ms.pop();//出堆�?
            jta.setText(str5);
        } else if ("剪贴".equals(str)) {
            ms.push(jta.getText());//入堆�?
            jta.cut();
        } else if ("拷贝".equals(str)) {
            jta.copy();
        } else if ("粘贴".equals(str)) {
            ms.push(jta.getText());//入堆�?
            jta.paste();
        } else if ("查找".equals(str)) {
            String str3 = JOptionPane.showInputDialog(jf, "请输入查找内�?");
            StringBuffer strbuf = new StringBuffer(jta.getText());
            int temp1 = strbuf.indexOf(str3);
            jta.select(temp1, (temp1 + str3.length()));
        } else if ("替换".equals(str)) {
            ms.push(jta.getText());//入堆�?
            exchange myExchange = new exchange(this);
        } else if ("删除".equals(str)) {
            ms.push(jta.getText());//入堆�?
            String str3 = jta.getSelectedText();
            StringBuffer str4 = new StringBuffer(jta.getText());
            str4.delete(str4.indexOf(str3), str4.indexOf(str3) + str3.length());
            str3 = new String(str4);
            jta.setText(str3);

        } else if ("时间".equals(str)) {
            ms.push(jta.getText());//入堆�?
            Date dt = new Date();
            SimpleDateFormat formater = new SimpleDateFormat();
            formater.applyPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            String str3 = formater.format(dt);
            StringBuffer sb1 = new StringBuffer(jta.getText());
            String temp = new String(sb1.append(str3));
            jta.setText(temp);
            /////////////////加载时间//////////////////////// 
        } else if ("字体".equals(str)) {
            ms.push(jta.getText());//入堆�? 
        } else if ("帮助主题".equals(str)) {
            help myhelp = new help(this);
        } else if ("关于记事�?".equals(str)) {
            javax.swing.JOptionPane.showMessageDialog(jf, "该记事本用java语言编写，作者：瑚江水�?�单位：陕西科技大学。时间：2010�?1�?27");
        }
    }

////////////////////替换�?////////////////////////
    class exchange implements ActionListener {

        JDialog jd;
        JTextField jf1;
        JTextField jf2;
        JTextArea jta;

        public exchange(Object obj) {
            if (obj instanceof NoteBook) {
                NoteBook nb = (NoteBook) obj;
                jd = new JDialog(nb.getJFrame(), "替换");
                jta = nb.getJTextArea();
            }

            jf1 = new JTextField(10);
            jf2 = new JTextField(10);

            JLabel jl1 = new JLabel("被替换对象：");
            JLabel jl2 = new JLabel("替换内容�?");

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

/////////////////帮助�?///////////////////
    class help implements ActionListener {

        JDialog jd;

        public help(Object obj) {
            if (obj instanceof NoteBook) {
                NoteBook nb = (NoteBook) obj;
                jd = new JDialog(nb.getJFrame(), "help");
            }

            JMenuBar jmb = new JMenuBar();

            JMenuItem jm1 = new JMenuItem("文件");
            jm1.addActionListener(this);
            JMenuItem jm2 = new JMenuItem("编辑");
            jm2.addActionListener(this);

            jmb.add(jm1);
            jmb.add(jm2);

            jd.add(jmb, BorderLayout.NORTH);

            jd.setSize(400, 290);
            Toolkit tk = Toolkit.getDefaultToolkit();
            jd.setLocation((tk.getScreenSize().width - jd.getSize().width) / 2, (tk.getScreenSize().height - jd.getSize().height) / 2);
            jd.setResizable(false);
            jd.setVisible(true);
            jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }

        public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method 
            System.out.println(1);
            if ("文件".equals(e.getActionCommand())) {
                javax.swing.JOptionPane.showMessageDialog(jd, "1：主要的功能有新建，打开，保存等�?2：具体的操作点击菜单即可");
            }
            if ("编辑".equals(e.getActionCommand())) {
                javax.swing.JOptionPane.showMessageDialog(jd, "1：主要的功能有撤�?，剪贴，粘贴，复制，删除等�??2：具体的操作点击菜单即可");
            }
        }
    }
//////////////////////////我的堆栈///////////////////////

    class myStack {

        List list;

        public myStack() {
            list = new ArrayList();
        }

        public void push(Object obj) {
            if (obj instanceof String) {
                String str = (String) obj;
                list.add(obj);
            } else {
                System.exit(0);
            }
        }

        public String pop() {
            String obj = (String) list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return obj;
        }
    }
//////////////////////////////////////////////////////////// 

    public static void main(String[] args) {
        NoteBook nb = new NoteBook();
    }

}

