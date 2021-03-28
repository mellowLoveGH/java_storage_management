package dd;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;

public class GUI extends JFrame{
	
	public GUI() {
		// TODO Auto-generated constructor stub
		//通讯录管理，提供显示、修改、插入、删除操作，提供查找和排序功能，提供按约定树形关系分类功能
		
		Container con = getContentPane();
		this.setLayout(null);
		
		JList jlist = new JList<>();
		
		
		
		this.setBounds(0, 575, 520, 160);;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	
	
}
