package com.qwk.notebook;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import java.util.Date;
import java.text.SimpleDateFormat;


public class example extends JFrame {
// 菜单
JMenuBar menub = new JMenuBar();
// 显示纯文本的多行区域
JTextArea text = new JTextArea();
JMenu files = new JMenu("文件(F)");
JMenu edit = new JMenu("编辑(E)");
JMenu formats = new JMenu("格式(O)");
JMenu help = new JMenu("帮助(H)");
JMenuItem newFile = new JMenuItem("新建(N)");
JMenuItem open = new JMenuItem("打开(O)");
JMenuItem save = new JMenuItem("保存(S)");
JMenuItem saveAs = new JMenuItem("另存�?(A)");
JMenuItem exit = new JMenuItem("�?�?(X)");
JMenuItem undo = new JMenuItem("撤销(U)");
JMenuItem cut = new JMenuItem("剪切(T)");
JMenuItem find = new JMenuItem("查找(F)");
JMenuItem replace = new JMenuItem("替换(R)");
JMenuItem copy = new JMenuItem("复制(C)");
JMenuItem paste = new JMenuItem("粘贴(P)");
JMenuItem selectAll = new JMenuItem("全�??(A)");
JMenuItem timeDate = new JMenuItem("时间/日期(D)");
JCheckBoxMenuItem lineWrap = new JCheckBoxMenuItem("自动换行(M)");
JMenuItem fonts = new JMenuItem("字体");
JMenuItem about = new JMenuItem("关于记事�?(A)");
JFrame th = this;
String name;
String openedPath = null;
boolean opened = false;
boolean reworked = false;
UndoManager undoManager = new UndoManager();




// 初始化窗�?
public example(String name) {
super(name);
this.name = name;




int x, y;
// 得到用户屏幕大小
Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
x = (size.width - 600) / 2;
y = (size.height - 400) / 2;
setSize(600, 400);
// 让程序界面显示在屏幕中央
setLocation(x, y);
// 将此窗口的最小大小设置为�?个常量�?��??
setMinimumSize(new Dimension(250, 150));
setDefaultCloseOperation(EXIT_ON_CLOSE);
}


// 初始化布�?
void init() {
files.setMnemonic('F');
edit.setMnemonic('E');
formats.setMnemonic('O');
help.setMnemonic('H');
newFile.setMnemonic('N');
open.setMnemonic('O');
save.setMnemonic('S');
saveAs.setMnemonic('A');
exit.setMnemonic('X');
undo.setMnemonic('U');
cut.setMnemonic('T');
find.setMnemonic('F') ;
replace.setMnemonic('R') ;
copy.setMnemonic('C');
paste.setMnemonic('P');
selectAll.setMnemonic('A');
timeDate.setMnemonic('D');
lineWrap.setMnemonic('M');
about.setMnemonic('A');
// 为控件添加助记符
newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
InputEvent.CTRL_MASK));
open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
InputEvent.CTRL_MASK));
save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
InputEvent.CTRL_MASK));
exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
InputEvent.CTRL_MASK));
cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
InputEvent.CTRL_MASK));
copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
InputEvent.CTRL_MASK));
find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
InputEvent.CTRL_MASK)); 
replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
InputEvent.CTRL_MASK)); 
paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
InputEvent.CTRL_MASK));
selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
InputEvent.CTRL_MASK));
// 为控件添加快捷键
timeDate.setAccelerator(KeyStroke.getKeyStroke("F5"));

files.add(newFile);
files.add(open);
files.add(save);
files.add(saveAs);
files.addSeparator();
files.add(exit);
edit.add(undo);
edit.addSeparator();
edit.add(cut);
edit.add(find);
edit.add(replace);
edit.add(copy);
edit.add(paste);
edit.addSeparator();
edit.add(selectAll);
edit.add(timeDate);
formats.add(lineWrap);
formats.add(fonts);
help.add(about);


menub.add(files);
menub.add(edit);
menub.add(formats);
menub.add(help);
setJMenuBar(menub);
getContentPane().add(new JScrollPane(text));


Listen listen = new Listen();
Listen1 listen1 = new Listen1();
// 为控件添加事件侦听器
newFile.addActionListener(listen);
undo.addActionListener(listen);
open.addActionListener(listen);
save.addActionListener(listen);
saveAs.addActionListener(listen);
exit.addActionListener(listen);
cut.addActionListener(listen);
find.addActionListener(listen);
replace.addActionListener(listen);
copy.addActionListener(listen);
paste.addActionListener(listen);
selectAll.addActionListener(listen);
timeDate.addActionListener(listen);
lineWrap.addActionListener(listen);
about.addActionListener(listen);
open.addActionListener(listen1);
save.addActionListener(listen1);
saveAs.addActionListener(listen1);
// 暂时没有实现的功�? :设置字体
//undo功能没有实现
fonts.setEnabled(false);

}
class Listen implements ActionListener {
// 实现用于�?般操作的事件侦听�?
public void actionPerformed(ActionEvent e) {
Object source = e.getSource();
if (source == newFile) {
text.setText("");
// 设置标题
th.setTitle(name);
openedPath = null;
opened = false;
} else if (source == exit)
setVisible(false);
else if (source == undo)
try {
//此功能没有实�? 撤销要用栈？
// undo.setEnabled(undoManager.canUndo());
undoManager.undo();
} catch (CannotRedoException cre) {
cre.printStackTrace();
}
else if (source == selectAll)
text.selectAll();
else if (source == cut)
text.cut();
else if (source == copy)
text.copy();
else if (source == paste)
text.paste();
else if (source == lineWrap)
// 设置文本区的换行策略(获取文本区的换行策略)
text.setLineWrap(!text.getLineWrap());
else if (source == about) {
String message = "--------\n版本�?1.0\n作�?�：时超" +
"\n撤销功能要用堆栈存贮操作" +
"\n还有字体格式"+
"\n暂时没有实现" +
"\n\n感谢您的使用";
JOptionPane.showMessageDialog(th, message, "关于",
JOptionPane.PLAIN_MESSAGE);
} else if (source == timeDate) {
Date nowTime = new Date();
SimpleDateFormat times = new SimpleDateFormat(
"HH:mm yyyy-MM-dd");
text.insert(times.format(nowTime), text.getCaretPosition());
}
}
}
class Listen1 implements ActionListener {
// 实现用于对文件进行操作的事件侦听�?
public void actionPerformed(ActionEvent e) {
Object source = e.getSource();
// 打开文件事件
if (source == open) {
// 显示对话窗口 以便选择文件
FileDialog openFile = new FileDialog(th, "打开文件",
FileDialog.LOAD);
openFile.setVisible(true);
// 获取文件路径
String filePath = openFile.getDirectory() + openFile.getFile();
try {
FileInputStream fis = new FileInputStream(filePath);
byte[] content = new byte[fis.available()];
fis.read(content);
text.setText(new String(content));
// 设置 TextComponent 的文本插入符的位�?
text.setCaretPosition(0);
if (openFile.getFile() != null) {
th.setTitle(openFile.getFile() + name);
openedPath = filePath;
opened = true;
}
fis.close();
} catch (Exception ex) {
ex.printStackTrace();
}
opened = true;
}
// 保存及另存为事件
else if (source == save || source == saveAs) {
String savePath = openedPath;
if (savePath == null || source == saveAs) {
// 如果 mode 的�?�为 LOAD，那么文件对话框将查找要读取的文件，�?显示的文件是当前目录中的文件
// 如果 mode 的�?�为 SAVE，则文件对话框将查找要写入文件的位置�?
FileDialog saveFile = new FileDialog(th, "保存文件",
FileDialog.SAVE);
saveFile.setVisible(true);
savePath = saveFile.getDirectory() + saveFile.getFile();
}
try {
FileOutputStream fos = new FileOutputStream(savePath);
fos.write(text.getText().getBytes());
fos.close();
} catch (Exception ex) {
ex.printStackTrace();
}
if (source == save)
openedPath = savePath;
}
}
}

	public static void main(String[] args) {
		try {
			// 使用当前线程的上下文类加载器加载给定类名称所指定�? LookAndFeel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Couldn't use the system look and feel:" + e);
		}
		String name = ("--记事�? 版本1.0--");
		example note = new example(name);
		note.init();
		note.setVisible(true);
	}
}
