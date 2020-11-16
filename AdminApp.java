package project2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class AdminApp {
	
	public static void AdminMenu(Admin admin) {
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\nWelcome, Admin " + admin.getAdminID());
			System.out.println("1: Add a new student");
			System.out.println("2: Delete student");
			System.out.println("3: Add a new course");
			System.out.println("4: Delete course");
			System.out.println("5: Add index groups"); 
			System.out.println("6: Delete index groups"); 
			System.out.println("7: Print list of course and index ");
			//System.out.println("7: Add lessons"); // is it ok to remove this?
			System.out.println("8: Check vacancy for an existing index group"); // same as Student option 5?
			System.out.println("9: Edit student access periods");
			System.out.println("10: Print list of all students");
			System.out.println("11: Print list of students by course");
			System.out.println("12: Print list of students by index group number");
			System.out.println("13: Logout");
			System.out.println("Please choose one of the options above.");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					Admin.addStudent();
					break;
				case 2:
					Admin.deleteStudent();
					break;
				case 3:
					Admin.addModule();
					break;
				case 4:
					Admin.deleteIndexOrCourse(false);
					break;
				case 5:
					Admin.addIndex();
					break;
				case 6:
					Admin.deleteIndexOrCourse(true);
					break;
				case 7:
					Admin.printCourseIndexList();
					break;
				//case 7: // is it ok to remove?
					//System.out.println("Enter Index No: "); 	//assume all courses have different index so here we dont ask for coursecode
					//String indexNum1 = sc.nextLine();
					//Index index1 = read.retrieve(indexNum1);
					//ArrayList<Lesson> lessons = Admin.addLesson();
					//index1.lessons.addAll(lessons);
					//IO.save(newIndex);
					//break;
				case 8: //Check vacancy for an existing index group
					Utils.checkVacancy();
					break;
				case 9:
					sc.nextLine();
					System.out.println("Enter username of student: ");
					String username = sc.nextLine();
					Student student1 = Utils.getStudentFromStuID(username);
					Admin.studentAccessPeriod(student1);
					break;
				case 10:
					Admin.printStuList("all");
					break;
				case 11:
					Admin.printStuList("course");
					break;
				case 12:
					Admin.printStuList("index");
					break;
				default:
					System.out.println("Please choose a proper option");
					break;
			}
			Utils.save("index");
			Utils.save("student");
//			Utils.prettyPrint();
		} while (choice > 0 && choice < 13);
	}
}