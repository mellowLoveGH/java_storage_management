package cc;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import aa.Message;

public class Messagelist {
	
	private String number = "";
	private List<Message> li = new LinkedList<Message>();
	
	public Messagelist(String num) {
		// TODO Auto-generated constructor stub
		this.number = num;
	}

	public String getNumber() {
		return number;
	}

	public List<Message> getList() {
		return li;
	}
	
	public void add(Message m){
		li.add(m);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.number;
	}
	
	public void print(){
		Collections.sort(li , new Ordering_Time());
		
		String str = "";
		Iterator<Message> it = li.iterator();
		while(it.hasNext()){
			Message m = it.next();
			str = str + "\t" + m.toString() + "\n";
		}
		System.out.print(str);
	}
	
}

class Ordering_Time implements Comparator<Message>{
	@Override
	public int compare(Message arg0, Message arg1) {
		// TODO Auto-generated method stub
		return (int) (arg1.getTime() - arg0.getTime());
	}
}