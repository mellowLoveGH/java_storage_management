package dd;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;

public class GUI extends JFrame{
	
	public GUI() {
		// TODO Auto-generated constructor stub
		//ͨѶ¼�����ṩ��ʾ���޸ġ����롢ɾ���������ṩ���Һ������ܣ��ṩ��Լ�����ι�ϵ���๦��
		
		Container con = getContentPane();
		this.setLayout(null);
		
		JList jlist = new JList<>();
		
		
		
		this.setBounds(0, 575, 520, 160);;
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	
	
}
