import java.util.Scanner;

public class JobShopSystem {

	private static int studentCounter = 0;
	private static Student[] studentList = new Student[50];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String selection;

		do {

			// Display menu options
			System.out.println("   ***** Job Shop System Menu *****");
			System.out.println("A. Add New Student");
			System.out.println("B. View student (job seeker) Information");
			System.out.println("C. Apply for a casual Job");
			System.out.println("D. Add New Research Student");
			System.out.println("E. Display Students Report");
			System.out.println("X. Exit the program");
			System.out.println();

			// prompt user to enter selection
			System.out.print("Enter selection: ");
			selection = sc.nextLine();

			System.out.println();

			// validate selection input length
			if (selection.length() != 1) {
				System.out.println("Error - invalid selection!");
			} else {

				// process user's selection
				switch (selection.toUpperCase()) {
				case "A":
					addNewStudent();
					break;

				case "B":
					viewstudentInformation();
					break;

				case "C":
					applyCasualJob();
					break;

				case "D":
					addNewresearchStudent();
					break;

				case "E":
					displaystudentsReport();
					break;

				case "X":
					System.out.println("Exiting the program...");
					break;

				default:
					System.out.println("Error - invalid selection!");
				}
			}
			System.out.println();

		} while (!selection.equalsIgnoreCase("X"));

	}

	private static Student findAStudent(String ID) {

		for (int i = 0; i < studentCounter; i++) {
			if (studentList[i].getID().equals(ID)) {
				return studentList[i];
			}
		}

		return null;
	}

	private static void addNewStudent() {

		System.out.println("Enter new Student's ID: ");
		String id = sc.nextLine();

		System.out.println("Enter new Student's Name: ");
		String name = sc.nextLine();

		System.out.println("Enter new Student's University Program: ");
		String program = sc.nextLine();

		studentList[studentCounter] = new Student(id, name, program);
		studentCounter++;

	}

	private static void viewstudentInformation() {

		String[] s = { "Student ID:", "Student name:", "Program:", "Employer:", "Job title:", "Working hours:" };

		System.out.println("Please enter a Student ID: ");
		String id = sc.nextLine();
		try {
			Student student = findAStudent(id);
			String[] information = student.printStudentDetails();

			for (int i = 0; i < s.length; i++) {
				System.out.printf("%s %-20s\n", s[i], information[i]);
			}
		} catch (NullPointerException e) {
			System.out.println("Student does not exist!");
		}
	}

	private static void applyCasualJob() {
		System.out.println("Please enter a Student ID: ");
		String id = sc.nextLine();
		double hours = 0.0;
		

		Student student = findAStudent(id);
		if (student == null) {
			System.out.println("Student does not exist!");
		}
		
		else {
			System.out.println("Enter Job Title being applied for: ");
			String jobTitle = sc.nextLine();

			System.out.println("Enter prospective Employer's Name: ");
			String employer = sc.nextLine();

			System.out.println("Enter working hours: ");
			hours = sc.nextDouble();

			if (student.addJob(hours) == true) {
				student.setJobTitle(jobTitle);
				student.setEmployer(employer);
				student.setWorkingHours(hours);
				System.out.print("Job information added and application successful!");
			}

			else {
				System.out.print("Job Application Unsuccessful! Applicant cannot work this many hours.");
			}
			sc.nextLine();
		}
		




	}

	private static void addNewresearchStudent() {

		System.out.println("Enter new Student's ID: ");
		String id = sc.nextLine();

		System.out.println("Enter new Student's Name: ");
		String name = sc.nextLine();

		System.out.println("Enter new Student's University Program: ");
		String program = sc.nextLine();

		studentList[studentCounter] = new ResearchStudent(id, name, program);
		studentCounter++;
	}

	private static void displaystudentsReport() {

		String[] s = { "Student ID:", "Student name:", "Program:", "Employer:", "Job title:", "Total Working hours:" };

		try {
			for (int i = 0; i < studentList.length; i++) {
				Student student = findAStudent(studentList[i].getID());
				String[] information = student.printStudentDetails();
				//
				for (int j = 0; j < s.length; j++) {
					System.out.printf("%s %-20s\n", s[j], information[j]);
				}
				System.out.print("\n");
			}
		} catch (NullPointerException e) {
		}
	}

}
