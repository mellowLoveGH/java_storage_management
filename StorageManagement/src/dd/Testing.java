package dd;

import bb.CallingManage;
import bb.MessageManage;
import bb.PhoneBookManage;

public class Testing {
	
	public static void main(String[] args) {
		
		//通讯录管理，提供显示、修改、插入、删除操作，提供查找和排序功能，提供按约定树形关系分类功能
		PhoneBookManage pbm = new PhoneBookManage();
		//1,显示;
		System.out.println("show the list");
		pbm.showing(PhoneBookManage.readingFromDB().iterator());
		System.out.println("------------------->");
		//2,修改,第二行那个的名字
		System.out.println("modify the name of the second one");
		pbm.modification(2, "name", "bbbbbbbb");
		System.out.println("------------------->");
		//3,插入,插入一行
		System.out.println("add a new one");
		pbm.adding("tianba", "65432109", 0);
		System.out.println("------------------->");
		//4,删除,第二行
		System.out.println("delete the second line");
		pbm.delete(2);
		System.out.println("------------------->");
		
		
		//通话清单管理，有效管理若干最近“未接来电”、“已接来电”、“已拨电话”等信息，
		//通讯录中已有的电话号码按人名显示，提供按姓名或时间排序等功能。
//		CallingManage cm  = new CallingManage();
//		//显示已接电话,按名字排序 
//		cm.haveAccepted("name");
//		System.out.println("------------------->");
//		//显示未接电话,按时间排序 
//		cm.nonAccepted("time");
//		System.out.println("------------------->");
//		//显示已拨电话,按名字排序 
//		cm.called("name");
//		System.out.println("------------------->");
		
		//短信息管理，将短信息分别存储在收件箱、发件箱、草稿箱中；
		//通讯录中已有的电话号码按人名显示；短消息按时间降序排列，每号码占一条信息，展开可查看所有收发分类信息；
		//提供短信息群发功能
		MessageManage mm = new MessageManage();
		//显示收件箱内容
		mm.receive();
		//显示发件箱内容
		mm.send();
		//显示草稿箱内容
		mm.draft();
		//短信息群发功能
		System.out.println();
		mm.notifyGroup();
	}
	
	
}
