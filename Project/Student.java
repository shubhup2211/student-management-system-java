package PracticeProject;

public class Student {

	//Private variables to store values
	private int id;
	private String firstName;
	private String lastName;
	private String place;
	private String password;
	private Marks m;
	
	//default constructor to create empty object
	public Student() {
		
	}
	
	//parameterize constructor to store values in created object
	public Student(int id, String firstName, String lastName, String place, String password) {
		super();    // explicitly call default constructor to store values in it
		this.id = id;
		this.firstName = firstName;
		this.lastName=lastName;
		this.place = place;
		this.password=password;
	}
	
	//Getter and Setter for get and set values
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Marks getMarks() {
		return m;
	}

	public void setMarks(Marks m) {
		this.m = m;
	}

	//toString method to print meaningful output instead of memory hashcode
	public String toString() {
		return id+"\t"+firstName+"\t\t"+lastName+"\t"+place+"\t"+password;
	}
	
}


