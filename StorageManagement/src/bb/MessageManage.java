package bb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import aa.Message;
import aa.PhoneBook;
import cc.Messagelist;
import cc.PrintMessage;

public class MessageManage {
	
	public List<String> messageList(String str){
		List<String> list = new LinkedList<String>();
		
		String[] st = str.split("\n");
		for (int i = 0; i < st.length; i++) {
			String s = st[i];
			s = s.split(";")[0];
			if (list.contains(s)) {
				
			}else{
				list.add(s);
			}
		}
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		return list;
	}
	
	
	
	
	
	public void receive(){
		processing("message_receive.txt");
	}
	
	public void send(){
		processing("message_send.txt");
	}
	
	public void draft(){
		processing("message_draft.txt");
	}
	
	public void notifyGroup(){
		
		Iterator<PhoneBook> it = PhoneBookManage.readingFromDB().iterator();
		while(it.hasNext()){
			PhoneBook pb = it.next();
			System.out.print("send message to :\t");
			System.out.println(pb.getName());
		}
		
	}
	
	
	public boolean contain(List<Messagelist> list , String number){
		
		Iterator<Messagelist> it = list.iterator();
		while(it.hasNext()){
			Messagelist temp = it.next();
			if(temp.equals(number)){
				return true;
			}
		}
		
		return false;
	}
	
	public Messagelist finding(List<Messagelist> list , String number){
		
		Iterator<Messagelist> it = list.iterator();
		while(it.hasNext()){
			Messagelist temp = it.next();
			if(temp.toString().equals(number.trim())){
				return temp;
			}
		}
		
		return null;
	}
	
	
	public void processing(String path){
		
		List<Messagelist> list = new LinkedList<Messagelist>();
		
		String str = "";
		try {
			str = readOut(path);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		messageList(str);
		//
		System.out.println("------------------>");
		
		String[] st = str.split("\n");
		for (int i = 0; i < st.length; i++) {
			String s = st[i];
			String[] item = s.split(";");
//			System.out.println();
			
			String number = item[0].trim();
			
//			BigInteger time = new BigInteger(item[1].trim());
			long time = Integer.parseInt(item[1].trim());
			
			String content = item[2];
//			System.out.println(time);
//			System.out.println();
//			System.out.println();
			
			Message m = new Message(time , number , content);
			Messagelist temp = finding(list, number);
			if(temp != null){
				temp.add(m);
			}else{
				Messagelist ml = new Messagelist(number);
				ml.add(m);
				list.add(ml);
			}
		}
		PrintMessage.printing(list);
		
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
//			File txt = new File("called.txt");
		File txt = new File(path);
		if (!txt.exists()) {
			txt.createNewFile();
		}
		byte bytes[] = new byte[512];
		bytes = str.getBytes();
		int b = bytes.length; // 是字节的长度，不是字符串的长度
		FileOutputStream fos = new FileOutputStream(txt);
		fos.write(bytes, 0, b);
//				 fos.write(bytes);
		fos.close();
	}
	
	
	public static void main(String[] args) {
		MessageManage mm = new MessageManage();
//		mm.receive();
//		mm.send();
//		mm.draft();
		mm.notifyGroup();
	}
}
