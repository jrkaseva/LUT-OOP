package main;

import java.util.Scanner;
/**
 * Author: Joakim Kaseva
 * LUT OOP course
 * Last modified 7.2.2023
 */
public class App {
	/**
	 * Scanner for user input
	 */
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * @param args not in use
	 */
	public static void main(String[] args){
		University uni = new University();
		int choice = menu();
		while (true){
			if (choice == 0) break;
			execute(choice, uni);
			choice = menu();
		}
		System.out.println("Kiitos ohjelman käytöstä.");
	}

	/**
	 * Prints the menu options
	 * @return choice of user to execute
	 */
	public static int menu(){
		String[] options = new String[] {"Lisää opiskelija", "Listaa opiskelijat", "Lisää opiskelijalle suorite", "Listaa opiskelijan suoritteet", "Laske opiskelijan suoritusten keskiarvo", "Laske opiskelijan suoritusten mediaani", "Tallenna opiskelijat tiedostoon", "Lataa opiskelijat tiedostosta"};
		for (int i = 1; i < options.length + 1; i++){
			System.out.print(String.format("%d) %s, ", i, options[i - 1]));}
		System.out.println("0) Lopeta ohjelma");
		int choice = SCANNER.nextInt();
		SCANNER.nextLine();
		return choice;
	}

	/**
	 * Decides on which action to preform based on user input
	 * @param number user's choice
	 * @param uni contains students
	 */
	public static void execute(int number, University uni){
		if (number == 1){
			addStudent(uni);
		}
		else if (number == 2){
			listStudents(uni);
		}
		else if (number == 3){
			addGradeToStudent(uni);
		}
		else if (number == 4){
			listGradesOfStudent(uni);
		}
		else if (number == 5){
			calculateAverageOfGrades(uni);
		}
		else if (number == 6){
			calculateMedianOfGrades(uni);
		}
		else if (number == 7){
			saveStudentsToFile(uni);
		}
		else if (number == 8){
			loadStudentsFromFile(uni);
		}
		else System.out.println("Väärä syöte.");
	}

	/**
	 * Takes user input and calls University.addStudent()
	 * @param uni from main
	 */
	public static void addStudent(University uni){
		System.out.println("Anna opiskelijan nimi?");
		String nimi = SCANNER.nextLine();
		System.out.println("Anna opiskelijan opiskelijanumero:");
		int nro = SCANNER.nextInt();
		SCANNER.nextLine();
		uni.addStudent(new Student(nimi, nro));
	}

	/**
	 * Calls University.listStudents()
	 * @param uni from main
	 */
	public static void listStudents(University uni){
		System.out.println("Opiskelijat:");
		uni.listStudents(true);
	}

	/**
	 * Gets user input and calls University.getStudent() and Student.addGrade() with them
	 * @param uni from main
	 */
	public static void addGradeToStudent(University uni){
		String text = "Mille opiskelijalle suorite lisätään?";
		int index_of_student = helperMethod(text, uni);
		System.out.println("Mille kurssille suorite lisätään?");
		String course = SCANNER.nextLine();
		System.out.println("Mikä arvosana kurssille lisätään?");
		int value = SCANNER.nextInt();
		SCANNER.nextLine();
		uni.getStudent(index_of_student).addGrade(course, value);
	}

	/**
	 * Calls University.getStudent() with user input and Student.listGrades()
	 * @param uni from main
	 */
	public static void listGradesOfStudent(University uni){
		String text = "Minkä opiskelijan suoritteet listataan?";
		int index_of_student = helperMethod(text, uni);
		uni.getStudent(index_of_student).listGrades();
	}

	/**
	 * Calls Calculator.getAverageGrade() with arguments
	 * @param uni from main
	 */
	public static void calculateAverageOfGrades(University uni){
		String text = "Minkä opiskelijan suoritteiden keskiarvo lasketaan?";
		int index = helperMethod(text, uni);
		double avg = Calculator.getAverageGrade(uni.getStudent(index));
		System.out.println(String.format("Keskiarvo on %.1f",  avg));
	}

	/**
	 * Calls Calculator.getMedianGrade() with arguments
	 * @param uni from main
	 */
	public static void calculateMedianOfGrades(University uni){
		String text = "Minkä opiskelijan suoritteiden mediaani lasketaan?";
		int index = helperMethod(text, uni);
		double med = Calculator.getMedianGrade(uni.getStudent(index));
		System.out.println(String.format("Mediaani on %.1f",  med));
	}

	/**
	 * Calls University.saveToFile()
	 * @param uni from main
	 */
	public static void saveStudentsToFile(University uni){
		uni.saveToFile("student_data.data");
	}

	/**
	 * Calls University.loadFromFile()
	 * @param uni form main
	 */
	public static void loadStudentsFromFile(University uni){
		uni.loadFromFile("student_data.data");
	}

	/**
	 * Contains code repeated in other methods
	 * @param text that is printed
	 * @param uni from main
	 * @return user's choice of student
	 */
	public static int helperMethod(String text, University uni){
		uni.listStudents(false);
		System.out.println(text);
		int index_of_student = SCANNER.nextInt();
		SCANNER.nextLine();
		return index_of_student;
	}
}