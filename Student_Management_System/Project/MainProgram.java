package PracticeProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {

	int choice = 0;
	int scount = 0; // for student count
	int tcount = 0; // teacher count
	String sfirstName, slastName, splace, spassword;  //address-->place
	String tfirstName, tlastName, tpassword;
	int java,python,sql,react;
	int tage;
	int sid = 1;
	int tid = 101;
	Scanner sc = new Scanner(System.in);
	Student student[] = new Student[40];
	Teacher teacher[] = new Teacher[10];
	Student currentStudent; // for login session

	public void call() {

		do {
			System.out.println("=================.WELCOME_TO_MIT-WPU.==================");
			System.out.println("|                                                     |");
			System.out.println("|           Press 1 : Register as teacher             |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 2 : Login as teacher                |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 3 : Register as student             |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 4 : Login as student                |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 5 : Exit                            |");
			System.out.println("-------------------------------------------------------");

			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				registerTeacher();
				break;
			case 2:
				loginTeacher();
				break;
			case 3:
				registerStudent();
				break;
			case 4:
				loginStudent();
				break;
			case 5:
				choice=0;
				break;			
			default:
				System.err.println("Please enter valid choice!");
			}

		} while (choice != 0);

	}
//-----------------------------------------------------------------------------------------------

	//1.Register As Student
	private void registerStudent() {
		System.out.println("=================.REGISTER_AS_STUDENT.=================");
		System.out.println("Enter your first name:");
		sfirstName = sc.next();

		System.out.println("Enter your last name:");
		slastName = sc.next();

		System.out.println("Enter your address:");
		splace = sc.next();

		System.out.println("Enter your password:");
		spassword = sc.next();
		
		student[scount]= new Student(sid, sfirstName, slastName, splace, spassword);
		System.out.println("\n===." + student[scount].getFirstName().toUpperCase() + " you successfully registered as student" + ".===");
		System.out.println("========." +student[scount].getFirstName().toUpperCase() + " you can login using id '" + sid + "'" + ".========");
		System.out.println("\n-------------------------------------------------------");
		
		scount++;
		sid++;
	}
	
	
//-----------------------------------------------------------------------------------------------
	
	//1.2 Login as Student
	private void loginStudent() {
		System.out.println("==================.LOGIN_AS_STUDENT.===================");
		
		//Prevent program crash from wrong input
		boolean resultChoice = true;
		int localId = 0;
		do {
			try {
				System.out.println("Enter your id:");
				localId = sc.nextInt();
				resultChoice = false;
			} catch (Exception e) {
				System.out.println("Enter valid id!");
				sc.next(); //clear buffers
			}
		}while(resultChoice);
		
		System.out.println("Enter your password:");
		String localPass = sc.next();
		
		boolean value=true;

		for(int i=0; i<student.length; i++) {
			if(student[i]!=null && student[i].getId()==localId && student[i].getPassword().equals(localPass)) {
				currentStudent = student[i]; // store current login student
				System.out.println(student[i].getFirstName().toUpperCase() + " logged in successfully!");
				System.out.println("\n-------------------------------------------------------");
				value=false;
				studentMenu();
			}
		}
		if(value) {
			System.err.println("Sorry, Invalid credentials!");
		}
	}

//-----------------------------------------------------------------------------------------------

	//1.3 Student Menu
	private void studentMenu() {
		do {

			System.out.println("===============.WELCOME_TO_STUDENT_MENU.===============");
			System.out.println("|                                                     |");
			System.out.println("|           Press 1 : Update Student Information      |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 2 : Student List                    |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 3 : View Marksheet                  |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 4 : Teacher List                    |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 5 : Return to Main menu             |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|           Press 6 : Exit System                     |");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				updateStudent();
				break;
			case 2:
				getStudentWithoutPass();
				break;
			case 3:
				getMarksheet();
				break;
			case 4:
				getTeacher();
				break;
			case 5:
				call();
				break;
			case 6:
				choice=0;
				break;
			default:
				System.err.println("Please enter valid choice!");
			}
		
		} while(choice!=0);

	}
//-----------------------------------------------------------------------------------------------
		
	// 1.get marksheet of student
	private void getMarksheet() {
		
		Marks m = currentStudent.getMarks(); //get marks of current logged in student
	
		if(m==null) {
			System.out.println("Marks not available\n");
			return; // prevent printing error
		}
		
		double percentage = (m.getJava() + m.getPython() + m.getSql() + m.getReact())*100/400;
		String result = (percentage >= 35) ? "PASS" : "FAIL";
		
		System.out.println("======================.MARKSHEET.======================");

		System.out.printf("\n=================.RESULT_OF_STUDENT_%-2d.================",currentStudent.getId());
		System.out.println("\n|                                                     |");
		System.out.println("|                      MARKSHEET                      |");
        System.out.println("|                                                     |");
		System.out.println("-------------------------------------------------------");
		System.out.println("|         SUBJECTS         |           MARKS          |");
		System.out.println("-------------------------------------------------------");
		System.out.printf("|           %-4s           |            %-3d           |","JAVA",m.getJava());
		System.out.println("\n-------------------------------------------------------");
		System.out.printf("|          %-6s          |            %-3d           |","PYTHON",m.getPython());
		System.out.println("\n-------------------------------------------------------");
		System.out.printf("|            %-3s           |            %-3d           |","SQL",m.getSql());
		System.out.println("\n-------------------------------------------------------");
		System.out.printf("|           %-5s          |            %-3d           |","REACT",m.getReact());
		System.out.println("\n-------------------------------------------------------");
		System.out.println("|                                                     |");
		System.out.printf("|    PERCENTAGE : %.2f%%           RESULT : %-4s      |",percentage, result);
		System.out.println("\n-------------------------------------------------------");

		System.out.println("\n-------------------------------------------------------");
	}
	
//-----------------------------------------------------------------------------------------------
	
	// 2. update student with id
	private void updateStudent() {
		System.out.println("====================.UPDATE_DETAILS.===================");
		
/// useful when you want to avoid update student details by another student
		System.out.println("Enter Student Id:");
		int localId = sc.nextInt();

		System.out.println("Enter password:");
		String localPass = sc.next();
		
		boolean value=true;
		boolean loopUpdate=true;

		for(int i=0; i<student.length; i++) {
//			allow student by checking Id and password
			if(student[i]!=null && student[i].getId()==localId && student[i].getPassword().equals(localPass)) {
				if (student[i] != null && student[i].getId() == localId) {
					do {
						System.out.println("====.Select what to update.====");
						System.out.println("|                             |");
						System.out.println("| Press 1 : Update first_name |");
						System.out.println("-------------------------------");
						System.out.println("| Press 2 : Update last_name  |");
						System.out.println("-------------------------------");
						System.out.println("| Press 3 : Update address    |");
						System.out.println("-------------------------------");
						System.out.println("| Press 4 : Update password   |");
						System.out.println("-------------------------------");


						System.out.println("Enter your choice");
						int localChoice = sc.nextInt();

						if (localChoice == 1) {
							System.out.println("Enter first_name to update");
							student[i].setFirstName(sc.next());
						} else if (localChoice == 2) {
							System.out.println("Enter last_name to update");
							student[i].setLastName(sc.next());
						} else if (localChoice == 3) {
							System.out.println("Enter address to update");
							student[i].setPlace(sc.next());
						} else if (localChoice == 4) {
							System.out.println("Enter password to update");
							student[i].setPassword(sc.next());
						} else {
							System.err.println("Please enter valid choice!");
						}


						System.out.println("\nDo you want to update another field?");
						System.out.println("Press Y/N");
						String var = sc.next();

						//loop to update more fields at one time
						if(var.equals("N")) {
							loopUpdate=false;
						} else if(var.equals("Y")) {
							loopUpdate=true;
						} else {
							System.out.println("Enter only Y/N");
						}
					} while(loopUpdate);
					System.out.println("Details updated successully for id " + localId);
					value = false;
				} 
			}
		}
		if (value) {
			System.err.println("Please enter valid Id!");
			sc.nextLine();
		}
		System.out.println("\n-------------------------------------------------------");
	}

//-----------------------------------------------------------------------------------------------
	
	// 3.Get all students for teacher-->Include passwords
	private void getStudentWithPass() {
		System.out.println("==================.ALL_STUDENTS_LIST.==================\n");
		System.out.printf("%-5s %-12s %-12s %-10s %-10s\n", "id", "first_name", "last_name", "address", "password");
		System.out.println("-------------------------------------------------------");

		for (Student s : student) {
			if (s != null) {
				System.out.printf("%-5d %-12s %-12s %-10s %-10s\n", s.getId(), s.getFirstName(), s.getLastName(),
						s.getPlace(), s.getPassword());
			}
		}
		System.out.println("\n-------------------------------------------------------");
	}

//-----------------------------------------------------------------------------------------------
	
	// 3.2 Get all students for student-->Exclude passwords
	private void getStudentWithoutPass() {
		System.out.println("==================.ALL_STUDENTS_LIST.==================\n");
		System.out.printf("\t%-5s %-12s %-12s %-10s\n", "id", "first_name", "last_name", "address");
		System.out.println("-------------------------------------------------------");

		for (Student s : student) {
			if (s != null) {
				System.out.printf("\t%-5d %-12s %-12s %-10s\n", s.getId(), s.getFirstName(), s.getLastName(),
						s.getPlace());
			}
		}
		System.out.println("\n-------------------------------------------------------");
	}	
	
//-----------------------------------------------------------------------------------------------
	
	// 4. Delete student by id
	private void deleteStudent() {
		System.out.println("====================.DELETE_RECORD.====================");
		System.out.println("Enter Id to delete record:");
		int localId = sc.nextInt(); // to get id from user to delete record

		System.err.println("Are you sure you want to delete student whose id is " + localId + "?");
		System.out.flush();
		System.out.println("Press Y/N");
		System.out.flush();
		String result = sc.next();

		boolean value = true;

		if (result.equalsIgnoreCase("Y")) {
			for (int j = 0; j < student.length; j++) {
				if (student[j] != null && student[j].getId() == localId) {
					student[j] = null;
					value = false;
					System.out.println("Student with id '" + localId + "' deleted successfully.");
				}
			}
			if (value) {
				System.err.println("Enter valid Id and try again!");
			}
		} else if (!result.equalsIgnoreCase("N")) {
			System.err.println("Please select valid choice!");
		}
		System.out.println("\n-------------------------------------------------------");
	}

// ========================================================================================================


	// 1. Register as Teacher
	private void registerTeacher() {
		System.out.println("=================.REGISTER_AS_TEACHER.=================");
		boolean success = false; // for age exception handling

		System.out.println("Enter your first name:");
		tfirstName = sc.next();
		
		System.out.println("Enter your last name:");
		tlastName = sc.next();

		while(!success) {
			try {
				System.out.println("Enter your age:");
				tage = sc.nextInt();
				success = true;
			} catch (InputMismatchException ie) {
				System.err.println("Please enter integer only\n");
				sc.nextLine();
			}
		}

		System.out.println("Enter your password:");
		tpassword = sc.next();

		teacher[tcount] = new Teacher(tid, tfirstName, tlastName, tage, tpassword);

		System.out.println("\n===." + tfirstName.toUpperCase() + " you successfully registerd as teacher" + ".===");
		System.out.println("========." + tfirstName.toUpperCase() + " you can log in using id '" + tid + "'.========");

		tcount++;
		tid++;
		System.out.println("\n-------------------------------------------------------");
	}
	
//-----------------------------------------------------------------------------------------------

	// 2.Login as Teacher
	private void loginTeacher() {
		System.out.println("==================.LOGIN_AS_TEACHER.===================");
		
		//Prevent program crash from wrong input
		boolean resultChoice = true;
		int localId = 0;
		do {
			try {
				System.out.println("Enter your id:");
				localId = sc.nextInt();
				resultChoice = false;
			} catch (Exception e) {
				System.out.println("Enter valid id!");
				sc.next(); //clear buffers
			}
		}while(resultChoice);
		
		boolean value = true;

		System.out.println("Enter your password:");
		String localPassword = sc.next();

		for (int i = 0; i < teacher.length; i++) {
			if (teacher[i] != null && teacher[i].getTId() == localId
					&& teacher[i].getTPassword().equals(localPassword)) {
				System.out.println(teacher[i].getTFirstName().toUpperCase() + " logged in successfully!");
				System.out.println("\n-------------------------------------------------------");
				value = false;
				teacherMenu();
			}
		}
		if (value) {
			System.err.println("Sorry, Invalid credentials!");
		}
	}
	
//...........................................................................................................
	
	// 2.1 Teacher menu
	private void teacherMenu() {
		do {
			System.out.println("===============.WELCOME_TO_TEACHER_MENU.===============");
			System.out.println("|                                                     |");
			System.out.println("|         Press 1 : Update Teacher Information        |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 2 : Teacher List                      |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 3 : Delete Teacher (by ID)            |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 4 : Record Student Marks              |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 5 : View Student Marks                |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 6 : Student List                      |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 7 : Delete Student (by ID)            |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 8 : Return to Main menu               |");
			System.out.println("-------------------------------------------------------");
			System.out.println("|         Press 9 : Exit System                       |");
			System.out.println("-------------------------------------------------------");

			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				updateTeacher();
				break;

			case 2:
				getTeacher();
				break;

			case 3:
				deleteTeacher();
				break;

			case 4:
				enterMarks();
				break;
				
			case 5:
				getAllStudentMarks();
				break;

			case 6:
				getStudentWithPass();
				break;

			case 7:
				deleteStudent();
				break;

			case 8:
				call();
				break;
				
			case 9:
				choice = 0;
				break;

			default:
				System.err.println("Your choice is invalid!, Please select valid choice.");
			}
		} while (choice != 0);
	}

//...........................................................................................................
	
	// 2.2 Update teacher
	private void updateTeacher() {
		System.out.println("====================.UPDATE_DETAILS.===================");
		System.out.println("Enter your id:");
		int localId=sc.nextInt();
		
		System.out.println("Enter your password:");
		String localPass=sc.next();
		
		boolean localCheck = true; //for checking valid id & pass
		boolean updateLoop = true; //for update more fields
		boolean success = false; // for age exception handling

		
		for(int i=0; i<teacher.length; i++) {
			if(teacher[i]!=null && teacher[i].getTId()==localId && teacher[i].getTPassword().equals(localPass)) {
				if(teacher[i]!=null && teacher[i].getTId()== localId) {
					do{ 
						System.out.println("====.Select what to update.====");
						System.out.println("| Press 1 : Update first_name |");
						System.out.println("| Press 2 : Update last_name  |");
						System.out.println("| Press 3 : Update age        |");
						System.out.println("| Press 4 : Update password   |");
						System.out.println("-------------------------------");


						System.out.println("Enter your choice:");
						int localChoice = sc.nextInt();

						if(localChoice==1) {
							System.out.println("Enter first_name to upate:");
							teacher[i].setTFirstName(sc.next());
						}
						else if(localChoice==2) {
							System.out.println("Enter last_name to update:");
							teacher[i].setTLastName(sc.next());
						} 
						else if(localChoice==3) {
							while(!success) {
								try {
									System.out.println("Enter age to update:");
									teacher[i].setTAge(sc.nextInt());
									success = true;
								} catch (InputMismatchException ie) {
									System.err.println("Please enter integer only\n");
									sc.nextLine();
								}
							}
							
						}
						else if(localChoice==4) {
							System.out.println("Enter password to update:");
							teacher[i].setTPassword(sc.next());
						} 
						else {
							System.err.println("Please enter valid choice");
							sc.nextLine();
						}

						System.out.println("Do you want to update another field?");
						System.out.println("Press Y/N");
						String var = sc.next();

						//loop to update more fields at one time
						if(var.equalsIgnoreCase("N")) {
							updateLoop=false;
						} else if(var.equalsIgnoreCase("Y")) {
							updateLoop=true;
						} else {
							System.err.println("Enter valid choice");
							break;
						}
						System.out.println("Details updated successully for id " + localId + "\n");
					} while(updateLoop);
					
					localCheck=false;
				}
			}
		}
		if(localCheck) {
			System.err.println("Sorry, Invalid credentials!");
		}
	}
//...........................................................................................................

	//2.3 Select all teacher
	private void getTeacher() {
		System.out.println("==================.ALL_TEACHERS_LIST.==================\n");
		System.out.printf("\t%-5s %-12s %-12s %-5s", "id", "first_name", "last_name", "age");
		
		System.out.println("\n-------------------------------------------------------");

		for(Teacher t : teacher) {
			if(t != null) {
				System.out.printf("\t%-5d %-12s %-12s %-5d \n",t.getTId(),t.getTFirstName(),t.getTLastName(),t.getTAge());
			}
		}
		System.out.println("\n-------------------------------------------------------");
	}
	
//...........................................................................................................

	//2.4 deleteTeacher
	private void deleteTeacher() {
		System.out.println("====================.DELETE_RECORD.====================");
		boolean check=true;
		
		do {
			boolean value=true;
			
			System.out.println("Enter id to delete record:");
			int localId=sc.nextInt();
			
			System.err.println("Are you sure you want to delete teacher whose id is " + localId + "?");
			sc.nextLine(); // buffer
			System.out.println("Press Y/N");
			String result = sc.next();
			
			if(result.equalsIgnoreCase("Y")) {
				for(int i=0; i<teacher.length; i++) {
					if(teacher[i]!=null && teacher[i].getTId()==localId) {
						teacher[i]=null;
						value=false;
						System.out.println("Teacher with id '" + localId + "' deleted successfully.");
					}
				} 
				if(value) {
					System.err.println("Error user not found with id " + localId);
					sc.nextLine();
				} 
			}  else if (!result.equalsIgnoreCase("N")) {
				System.err.println("Please select valid choice!");
				sc.nextLine();
				break;
			}
			
			System.out.println("\nDo you want to delete another record?");
			System.out.println("Press Y/N");
			String data=sc.next();
			
			if(data.equalsIgnoreCase("N")) {
				check=false;
			} else if(data.equalsIgnoreCase("Y")) {
				check=true;
			} else {
				System.err.println("Select valid choice");
				sc.nextLine();
				break;
			}

		} while(check);
	}
	
//...........................................................................................................

	//2.5 Enter Marks 
	private void enterMarks() {
		System.out.println("=====================.ENTER_MARKS.=====================");
		System.out.println("Enter Id of student to enter marks:");
		int localId=sc.nextInt();
		
		boolean value=true;
		String updateChoice;
		
		for(int i=0; i<student.length; i++) {
			if(student[i]!=null && student[i].getId()==localId) {
				System.out.println("Enter marks for " + student[i].getFirstName());
				
				do { // To enter and update marks
					System.out.println("Enter marks of JAVA:");
					java = sc.nextInt();
					
					System.out.println("Enter marks of PYTHON:");
					python = sc.nextInt();
					
					System.out.println("Enter marks of SQL:");
					sql = sc.nextInt();
					
					System.out.println("Enter marks of React:");
					react = sc.nextInt();
					
				    Marks marks = new Marks(java, python, sql, react);

				    if(student[i].getMarks() == null) {
				        student[i].setMarks(marks);   // first time
				    } else {
				    	System.err.println("\nMarks of student are already filled!");
				    	sc.nextLine();
				    	System.out.println("Do you wish to update marks? Y/N");
				    	String localChoice = sc.next();
				    	
				    	if(localChoice.contains("Y")) {
				    		 // update existing object
					        Marks m = student[i].getMarks();
					        m.setJava(java);
					        m.setPython(python);
					        m.setSql(sql);
					        m.setReact(react);
				    	}
				      
				    }
					
					value=false;
					System.out.println("Marks of student " + student[i].getFirstName() + " entered succefully.");
					
					System.out.println("\n========.ENTERED_MARKS.==========");
					System.out.println("|    SUBJECTS   |     MARKS     |");
					System.out.println("---------------------------------");
					Marks m = student[i].getMarks();
					System.out.printf("|      %-7s  |      %-3s      |\n","JAVA", m.getJava());
					System.out.printf("|     %-8s  |      %-3s      |\n","PYTHON", m.getPython());
					System.out.printf("|      %-7s  |      %-3s      |\n","SQL", m.getSql());
					System.out.printf("|     %-7s   |      %-3s      |\n","REACT", m.getReact());
					System.out.println("---------------------------------");
					
					System.out.println("Do you want to update any marks?");
					System.out.println("Press Y/N");
					updateChoice = sc.next();
				} while(updateChoice.contains("Y"));
			}
		} if (value) {
			System.err.println("Enter valid Id to procceed!");
		  }
	}
	
//-------------------------------------------------------------------------------------------------------------------

	private void getAllStudentMarks() {

	    System.out.println("==================.ALL_STUDENT_MARKS.==================\n");

	    System.out.printf("%-5s %-8s %-8s %-8s %-8s %-8s\n",
	            "ID", "JAVA", "PYTHON", "SQL", "REACT", "TOTAL");

	    System.out.println("-------------------------------------------------------");

	    for(Student s : student) {

	        if(s != null) {

	            Marks m = s.getMarks();

	            // 🔥 if marks not added
	            if(m == null) {
	                System.out.printf("%-5d %-8s %-8s %-8s %-8s %-8s\n",
	                        s.getId(), "-", "-", "-", "-", "-");
	            } 
	            else {
	                int total = m.getJava() + m.getPython() + m.getSql() + m.getReact();

	                System.out.printf("%-5d %-8d %-8d %-8d %-8d %-8d\n",
	                        s.getId(),
	                        m.getJava(),
	                        m.getPython(),
	                        m.getSql(),
	                        m.getReact(),
	                        total);
	            }
	        }
	    }

	    System.out.println("\n-------------------------------------------------------");
	}
	public static void main(String[] args) {
		MainProgram s = new MainProgram();
		s.call();
	}

}
