package aa;

public class Message {
	
	private long time = 0;
	private String number = "";
	private String content = "";
	
	public Message(long time , String number , String content) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.number = number;
		this.content = content;
	}

	public long getTime() {
		return time;
	}

	public String getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.valueOf(this.time);
		
		return "20" + str.substring(0, 2) + "/" 
			+ str.substring(2, 6) + "/" + str.substring(6, 8) + ":" + str.substring(8, 10) + ";" + this.content;
	}
}
