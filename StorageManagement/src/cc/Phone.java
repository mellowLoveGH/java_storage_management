package cc;

public class Phone {
	
	private String n = "";
	private long time = 0;
	
	public Phone(String n , long time) {
		// TODO Auto-generated constructor stub
		this.n = n;
		this.time = time;
	}

	public String getN() {
		return n;
	}

	public long getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.valueOf(this.time);
		
		return this.n + " \t 20" + str.substring(0, 2) + "/" 
			+ str.substring(2, 6) + "/" + str.substring(6, 8) + ":" + str.substring(8, 10);
	}
}
