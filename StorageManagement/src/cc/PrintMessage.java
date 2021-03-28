package cc;

import java.util.Iterator;
import java.util.List;

import bb.CallingManage;

public class PrintMessage {
	
	public static void printing(List<Messagelist> list){
		
		Iterator<Messagelist> it = list.iterator();
		while(it.hasNext()){
			Messagelist ml = it.next();
			String s = CallingManage.findingFromBook(ml.getNumber());
			if (s.equals("unknown")) {
				System.out.println(ml);
			}else{
				System.out.println(s);
			}
//			System.out.println(ml);
			ml.print();
		}
	}
	
	
}
