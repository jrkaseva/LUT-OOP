package main;
import java.util.Scanner;
/**
*Author: Joakim Kaseva
*/
public class App {
	public static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Tervetuloa Gifu-järjestelmään\nMille yliopistolle haluat ottaa järjestelmän käyttöön?");
		String name = sc.nextLine();
		Gifu uni = new Gifu(name);
		int choice = menu();
		while (true){
			if (choice == 0) break;
			execute(choice, uni);
			choice = menu();
		}
		System.out.println("Kiitos ohjelman käytöstä.");
	}

	public static int menu(){
		String[] options = new String[] {"Luo uusi kurssi", "Luo uusi opiskelija", "Listaa kurssit", "Listaa opiskelijat", "Lisää opiskelija kurssille", "Anna kurssiarvosanat", "Listaa kurssilla olevat opiskelijat", "Listaa opiskelijan arvosanat", "Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat"};
		for (int i = 1; i < options.length + 1; i++){
			System.out.print(String.format("%d) %s, ", i, options[i - 1]));}
		System.out.println("0) Lopeta ohjelma");
		System.out.println("Valintasi: ");
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}

	/**
	 * @param number
	 */
	public static void execute(int number, Gifu uni){
		if (number == 1){
			createNewCourse(uni);
		}
		else if (number == 2){
			createNewStudent(uni);
		}
		else if (number == 3){
			listCourses(uni);
		}
		else if (number == 4){
			listStudents(uni);
		}
		else if (number == 5){
			addStudentToCourse(uni);
		}
		else if (number == 6){
			giveCourseGrades(uni);
		}
		else if (number == 7){
			listStudentsInCourse(uni);
		}
		else if (number == 8){
			listGradesOfStudent(uni);
		}
		else if (number == 9){
			listFromEveryCourseEveryStudentGrade(uni);
		}
		else System.out.println("Valintaa ei tunnistettu, yritä uudestaan.");
	}

	public static void createNewCourse(Gifu uni){
		System.out.println("Anna kurssin nimi:");
		String name = sc.nextLine();
		System.out.println("Anna kurssin ID:");
		String id = sc.nextLine();
		System.out.println("Anna kurssin maksimi opiskelijamäärä:");
		int max_students = sc.nextInt();
		sc.nextLine();
		uni.addCourse(new Course(name, id, max_students));
	}

	public static void createNewStudent(Gifu uni){
		System.out.println("Anna opiskelijan nimi:");
		String name = sc.nextLine();
		System.out.println("Anna opiskelijan opiskelijanumero:");
		String id = sc.nextLine();
		uni.addStudent(new Student(name, id));
	}

	public static void listCourses(Gifu uni){
		uni.listCourses();
	}

	public static void listStudents(Gifu uni){
		uni.listStudents();
	}

	public static void addStudentToCourse(Gifu uni){
		listCourses(uni);
		System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
		int idx_course = sc.nextInt();
		sc.nextLine();
		listStudents(uni);
		System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
		int idx_student = sc.nextInt();
		sc.nextLine();
		uni.enrollStudent(uni.getStudent(idx_student), uni.getCourse(idx_course));
	}

	public static void giveCourseGrades(Gifu uni){
		uni.listCourses();
		System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
		int idx_course = sc.nextInt();
		sc.nextLine();
		for(Enrollment e : uni.getEnrollments()){
			if (e.getCourse() == uni.getCourse(idx_course)){
				System.out.println("Anna arvosana opsieklijalle " + e.getStudent().getInformation());
				int grade = sc.nextInt();
				sc.nextLine();
				e.gradeCourse(grade);
			}
		}
	}

	public static void listStudentsInCourse(Gifu uni){
		uni.listCourses();
		System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
		int idx_course = sc.nextInt();
		sc.nextLine();
		for(Enrollment e : uni.getEnrollments()){
			if (e.getCourse() == uni.getCourse(idx_course)){
				System.out.println(e.getStudent().getInformation() + ", arvosana: " + e.getGrade());
			}
		}
	}

	public static void listGradesOfStudent(Gifu uni){
		uni.listStudents();
		System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
		int idx_student = sc.nextInt();
		sc.nextLine();
		Student s = uni.getStudent(idx_student);
		System.out.println("Opiskelijan " + s.getInformation() + " arvosanat:");
		for (Enrollment e : uni.getEnrollments()){
			if (e.getStudent() == s){
				System.out.println(e.getCourse() + ", arvosana: " + e.getGrade());
			}
		}
	}

	public static void listFromEveryCourseEveryStudentGrade(Gifu uni){
		for(Course c : uni.getCourses()){
			System.out.println(c.getInformation());
			for(Enrollment e : uni.getEnrollments()){
				if(e.getCourse() == c){
					System.out.println(e.getStudent() + ", arvosana: " + e.getGrade());
				}
			}
		}
	}
	
}