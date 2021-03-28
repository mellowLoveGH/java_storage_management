package aa;

public class Calling {
	
	private String time = "";
	public String getTime() {
		return time;
	}

	private PhoneBook pb = null;
	
	public Calling(String time , String number) {
		// TODO Auto-generated constructor stub
		this.pb = new PhoneBook("unknown" , number , 2);
		this.time = time;		
	}
	
	public Calling(String time , String name , String number , int rs) {
		// TODO Auto-generated constructor stub
		this.pb = new PhoneBook(name , number , rs);
		this.time = time;	
	}

	public PhoneBook getPb() {
		return pb;
	}

	public void setPb(PhoneBook pb) {
		this.pb = pb;
	}
	
}
