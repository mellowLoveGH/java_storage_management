package dd;

import bb.CallingManage;
import bb.MessageManage;
import bb.PhoneBookManage;

public class Testing {
	
	public static void main(String[] args) {
		
		//ͨѶ¼�����ṩ��ʾ���޸ġ����롢ɾ���������ṩ���Һ������ܣ��ṩ��Լ�����ι�ϵ���๦��
		PhoneBookManage pbm = new PhoneBookManage();
		//1,��ʾ;
		System.out.println("show the list");
		pbm.showing(PhoneBookManage.readingFromDB().iterator());
		System.out.println("------------------->");
		//2,�޸�,�ڶ����Ǹ�������
		System.out.println("modify the name of the second one");
		pbm.modification(2, "name", "bbbbbbbb");
		System.out.println("------------------->");
		//3,����,����һ��
		System.out.println("add a new one");
		pbm.adding("tianba", "65432109", 0);
		System.out.println("------------------->");
		//4,ɾ��,�ڶ���
		System.out.println("delete the second line");
		pbm.delete(2);
		System.out.println("------------------->");
		
		
		//ͨ���嵥������Ч�������������δ�����硱�����ѽ����硱�����Ѳ��绰������Ϣ��
		//ͨѶ¼�����еĵ绰���밴������ʾ���ṩ��������ʱ������ȹ��ܡ�
//		CallingManage cm  = new CallingManage();
//		//��ʾ�ѽӵ绰,���������� 
//		cm.haveAccepted("name");
//		System.out.println("------------------->");
//		//��ʾδ�ӵ绰,��ʱ������ 
//		cm.nonAccepted("time");
//		System.out.println("------------------->");
//		//��ʾ�Ѳ��绰,���������� 
//		cm.called("name");
//		System.out.println("------------------->");
		
		//����Ϣ����������Ϣ�ֱ�洢���ռ��䡢�����䡢�ݸ����У�
		//ͨѶ¼�����еĵ绰���밴������ʾ������Ϣ��ʱ�併�����У�ÿ����ռһ����Ϣ��չ���ɲ鿴�����շ�������Ϣ��
		//�ṩ����ϢȺ������
		MessageManage mm = new MessageManage();
		//��ʾ�ռ�������
		mm.receive();
		//��ʾ����������
		mm.send();
		//��ʾ�ݸ�������
		mm.draft();
		//����ϢȺ������
		System.out.println();
		mm.notifyGroup();
	}
	
	
}
