package aa;

public class PhoneBook implements Comparable<PhoneBook>{
	
	enum Relationship {  
	    family, friend, other 
	} 
	
	private String name = "";
	private String number = "";
	private Relationship group = Relationship.other;
	
	public PhoneBook(String name , String number , int rs) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.number = number;
		if(rs == 0){
			group = Relationship.family;
		}else if(rs == 1){
			group = Relationship.friend;
		}else{
			group = Relationship.other;
		}
	}
	
	public PhoneBook() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = name + ";" + number + ";";
		if(group == Relationship.family){
			str += "family";
		}else if(group == Relationship.friend){
			str += "friend";
		}else{
			//group == Relationship.other
			str += "other";
		}
		
		return str;
	}

	@Override
	public int compareTo(PhoneBook arg0) {
		// TODO Auto-generated method stub
		if(this.number.equals(arg0.getNumber())){
			return 0;
		}
		return 1;
	}
	
}
