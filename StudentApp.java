package project2;

import java.util.Scanner;

public class StudentApp {
	public static void StudentMenu(Student me) throws Exception {

		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("\n1. Add course");
			System.out.println("2. Drop course");
			System.out.println("3. Swap index");
			System.out.println("4. Change index");
			System.out.println("5. Check vacancy");
			System.out.println("6. Print enrolled courses");
			System.out.println("7. Log out");
			System.out.println("Enter choice: ");
				
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					me.addModule();
					break;
				case 2:
					me.dropModule(true);
					break;
				case 3:
					me.swapIndex();
					break;
				case 4:
					me.changeIndex();
					break;
				case 5:
					Utils.checkVacancy();
					break;
				case 6:
					me.printModules();
					break;
//				case 7:
//					System.out.println("System terminating...");
			}
			Utils.save("index");
			Utils.save("student");
			Utils.prettyPrint();
		} while (choice < 7);
//	sc.close();
	}
}

