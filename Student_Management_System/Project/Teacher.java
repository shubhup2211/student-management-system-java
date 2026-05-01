package PracticeProject;

public class Teacher {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String password;
	
	Teacher(){
		
	}
	
	Teacher(int id, String firstName, String lastName, int age, String password){
		super();
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.password=password;
	}
	
	public int getTId() {
		return id;
	}
	public void setTId(int id) {
		this.id=id;
	}
	public String getTFirstName() {
		return firstName;
	}
	public void setTFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getTLastName() {
		return lastName;
	}
	public void setTLastName(String lastName) {
		this.lastName=lastName;
	}
	public int getTAge() {
		return age;
	}
	public void setTAge(int age) {
		this.age=age;
	}
	public String getTPassword() {
		return password;
	}
	public void setTPassword(String password) {
		this.password=password;
	}
	
	public String toString() {
		return id+"\t"+firstName+"\t"+lastName+"\t"+age+"\t"+password;
	}
}
