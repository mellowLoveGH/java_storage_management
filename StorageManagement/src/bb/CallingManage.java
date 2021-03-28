package bb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import aa.PhoneBook;
import cc.OrderCalling;
import cc.Phone;

public class CallingManage {
	
	public void haveAccepted(String order){
		
		List<Phone> list = new LinkedList<Phone>();
		
		String str = "";
		try {
			str = readOut("haveAccepted.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] st = str.split("\n");
		for (int i = 0; i < st.length; i++) {
			
			String s = st[i].trim();
			String[] arr = s.split(";");
			s = arr[0].trim();
//			s = s.trim();
			
			String n = "";
			long time = Integer.parseInt(arr[1].trim());
			
			if(findingFromBook(s).equals("unknown")){
//				System.out.print(s);
//				System.out.println("\t" + time);
				n = s;
			}else{
//				System.out.print(findingFromBook(s));
//				System.out.println("\t" + time);
				n = findingFromBook(s);
			}
			
			Phone ph = new Phone(n, time);
			list.add(ph);
		}
		//System.out.println("=============================");
		if (order.equals("name")) {
			OrderCalling.orderingByName(list);
		}else{
			OrderCalling.orderingByTime(list);
		}
		
	}
	
	public void nonAccepted(String order){
		List<Phone> list = new LinkedList<Phone>();
		
		String str = "";
		try {
			str = readOut("nonAccepted.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] st = str.split("\n");
		for (int i = 0; i < st.length; i++) {
			
			String s = st[i].trim();
			String[] arr = s.split(";");
			s = arr[0].trim();
//			s = s.trim();
			
			String n = "";
			long time = Integer.parseInt(arr[1].trim());
			
			if(findingFromBook(s).equals("unknown")){
//				System.out.print(s);
//				System.out.println("\t" + time);
				n = s;
			}else{
//				System.out.print(findingFromBook(s));
//				System.out.println("\t" + time);
				n = findingFromBook(s);
			}
			
			Phone ph = new Phone(n, time);
			list.add(ph);
		}
		//System.out.println("=============================");
		if (order.equals("name")) {
			OrderCalling.orderingByName(list);
		}else{
			OrderCalling.orderingByTime(list);
		}
		
	}
	
	public void called(String order){
		List<Phone> list = new LinkedList<Phone>();
		
		String str = "";
		try {
			str = readOut("called.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] st = str.split("\n");
		for (int i = 0; i < st.length; i++) {
			
			String s = st[i].trim();
			String[] arr = s.split(";");
			s = arr[0].trim();
//			s = s.trim();
			
			String n = "";
			long time = Integer.parseInt(arr[1].trim());
			
			if(findingFromBook(s).equals("unknown")){
//				System.out.print(s);
//				System.out.println("\t" + time);
				n = s;
			}else{
//				System.out.print(findingFromBook(s));
//				System.out.println("\t" + time);
				n = findingFromBook(s);
			}
			
			Phone ph = new Phone(n, time);
			list.add(ph);
		}
		//System.out.println("=============================");
		if (order.equals("name")) {
			OrderCalling.orderingByName(list);
		}else{
			OrderCalling.orderingByTime(list);
		}
		
	}
	
	public static String findingFromBook(String number){
		String name = "unknown";
		
		TreeSet<PhoneBook> tr = PhoneBookManage.readingFromDB();
		Iterator<PhoneBook> it = tr.iterator();
		PhoneBook pb = null;
		while (it.hasNext()) {
			pb = it.next();
			if(pb.getNumber().equals(number)){
				name = pb.getName();
			}
		}
		
		return name;
	}
	
	
	// read the decoding file and print out the content
	public static String readOut(String fileName) throws IOException {
		File file = new File(fileName);
        @SuppressWarnings("resource")
		FileReader reader = new FileReader(file);
        int fileLen = (int)file.length();
        char[] chars = new char[fileLen];
        reader.read(chars);
        String txt = String.valueOf(chars);
       // System.out.println(txt);
        return txt;
	}
	
	public static void writeIn(String str , String path) throws IOException {
//		File txt = new File("called.txt");
		File txt = new File(path);
		if (!txt.exists()) {
			txt.createNewFile();
		}
		byte bytes[] = new byte[512];
		bytes = str.getBytes();
		int b = bytes.length; // 是字节的长度，不是字符串的长度
		FileOutputStream fos = new FileOutputStream(txt);
		fos.write(bytes, 0, b);
//			 fos.write(bytes);
		fos.close();
	}	
	
	public String ordering(){
		
		return "";
	}
	
	public static void main(String[] args) {
		CallingManage cm  = new CallingManage();
//		System.out.println(cm.findingFromBook("77777777"));
		cm.haveAccepted("name");
//		cm.nonAccepted();
//		cm.called("name");
	}
	
}





