package cc;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class OrderCalling {
	
	public static void orderingByName(List<Phone> list){
		
//		list.sort();
		Collections.sort(list , new Comparator_Name());
		
		Iterator<Phone> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void orderingByTime(List<Phone> list){
		
		Collections.sort(list , new Comparator_Time());
		Iterator<Phone> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

class Comparator_Time implements Comparator<Phone>{
	@Override
	public int compare(Phone arg0, Phone arg1) {
		// TODO Auto-generated method stub
		return (int) (arg1.getTime() - arg0.getTime());
	}
}

class Comparator_Name implements Comparator<Phone>{
	@Override
	public int compare(Phone arg0, Phone arg1) {
		// TODO Auto-generated method stub
		return arg0.getN().compareTo(arg1.getN());
	}
}