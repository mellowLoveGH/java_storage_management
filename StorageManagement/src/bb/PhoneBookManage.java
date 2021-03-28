package bb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

import aa.PhoneBook;

public class PhoneBookManage {
	
	
	public static TreeSet<PhoneBook> readingFromDB(){
		
		TreeSet<PhoneBook> tr = new TreeSet<PhoneBook>();
		
		String str = "";
		try {
			str = readOut("DB.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] st = str.split("\n");
		for (int i = 0; i < st.length; i++) {
			String[] s = st[i].split(";");
			int group = 0;
			if(s[2].trim().equals("0")){
				group = 0;
			}else if(s[2].trim().equals("1")){
				group = 1;
			}else{
				group = 2;
			}
			PhoneBook pb = new PhoneBook(s[0] , s[1] ,  group);
			tr.add(pb);
//			System.out.println(pb);
		}
		
		return tr;
	}
	
	public void showing(Iterator<PhoneBook> it){
		
//		Iterator<PhoneBook> it = readingFromDB().iterator();
		int index = 0;
		
		while (it.hasNext()) {
			index ++;
			System.out.print(index + "\t");
        	System.out.println(it.next());
		}
	}
	
	public void modification(int index , String whichone , String modify){
		
		TreeSet<PhoneBook> tr = readingFromDB();
		int num = 0;
		Iterator<PhoneBook> it = tr.iterator();
		PhoneBook pb = null;
		while (it.hasNext()) {
			num ++;
			pb = it.next();
			if(num == index){
				break;
			}
		}
		
		if(whichone.equals("name")){
			pb.setName(modify);
		}
		if(whichone.equals("number")){
			pb.setName(modify);
		}
//		if(whichone.equals("relationship")){
//			if(modify.equals("0")){
//				pb.
//			}
//		}
		
		showing(tr.iterator());
		
		//save the modification
		String str = "";
		it = tr.iterator();
		while (it.hasNext()) {
			str += it.next();
			str += "\n";
		}
		
		try {
			writeIn(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int index){
		TreeSet<PhoneBook> tr = readingFromDB();
		
		//find it
		int num = 0;
		Iterator<PhoneBook> it = tr.iterator();
		PhoneBook pb = null;
		while (it.hasNext()) {
			num ++;
			pb = it.next();
			if(num == index){
				break;
			}
		}
		
		//delete it
		String str = "";
		it = tr.iterator();
		PhoneBook temp;
		while (it.hasNext()) {
			temp = it.next();
			if(temp.equals(pb)){
				
			}else{
				str += temp;
				str += "\n";
			}
		}
		
		//save it
		try {
			writeIn(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		showing(readingFromDB().iterator());
	}
	
	public void adding(String name , String number , int rs){
		
		PhoneBook pb = new PhoneBook(name, number, rs);
		TreeSet<PhoneBook> tr = readingFromDB();
		tr.add(pb);
		
		
		Iterator<PhoneBook> it = tr.iterator();
		//save the modification
		String str = "";
		it = tr.iterator();
		while (it.hasNext()) {
			str += it.next();
			str += "\n";
		}
		
		try {
			writeIn(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showing(readingFromDB().iterator());
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
	
	public static void writeIn(String str) throws IOException {
		File txt = new File("DB.txt");
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
	
	
	public static void main(String[] args) {
		PhoneBookManage pbm = new PhoneBookManage();
		pbm.showing(PhoneBookManage.readingFromDB().iterator());
		System.out.println("------------------->");
//		pbm.modification(2, "name", "lalalal");
//		pbm.delete(2);
//		pbm.adding("andy", "12345678", 0);
	}
}
