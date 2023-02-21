package main;

import java.util.Scanner;
/**
 * LUT OOP -course
 * Contains a menu with options on how to interact with a zoo.
 * Author: Joakim Kaseva
 * Last modified: 1.2.2023
*/
public class App {
	// Constant scanner for input
	public static final Scanner sc = new Scanner(System.in);

	/**
	 * Main method that receives the user's choice from menu()-method and gives it to execute()-method.
	 * Also creates a zoo which can be handed down to other methods.
	 * @param args none
	 */
	public static void main(String[] args){
		System.out.println("Anna eläintarhalle nimi:");
		Zoo zoo = new Zoo(sc.nextLine());

		// Get the user's choice
		int choice = menu();

		// If the choice is 0, end program. Otherwise Loop.
		while (true){
			if (choice == 0) break;

			// Do something
			execute(choice, zoo);
			choice = menu();
		}
		// END
		System.out.println("Kiitos ohjelman käytöstä.");
	}

	/**
	 * Menu method with options for user to choose from
	 * @return user's choice
	 */
	public static int menu(){
		String[] options = new String[] {"Luo uusi eläin", "Listaa kaikki eläimet", "Juoksuta eläimiä"};
		System.out.println(String.format("1) %s, 2) %s, 3) %s, 0) Lopeta ohjelma", options[0], options[1], options[2]));
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}

	/**
	 * Compares the user's choice to options and forwards to another method
	 * @param number user's choice
	 * @param zoo from main method
	 */
	public static void execute(int number, Zoo zoo){
		if (number == 1){
			luouusielain(zoo);
		}
		else if (number == 2){
			listaakaikkielaimet(zoo);
		}
		else if (number == 3){
			juoksutaelaimia(zoo);
		}
		else System.out.println("syöte oli väärä");
	}

	/**
	 * Creates a new animal for the zoo
	 * @param zoo from main
	 * @return 0 if no issues
	 */
	public static int luouusielain(Zoo zoo){
		System.out.println("Mikä laji?");
		String specie = sc.nextLine();
		System.out.println("Anna eläimen nimi:");
		String name = sc.nextLine();
		System.out.println("Anna eläimen ikä:");
		int age = sc.nextInt();
		sc.nextLine();
		zoo.addAnimal(new Animal(specie, name, age));
		return 0;
	}

	/**
	 * Calls the listAnimals()-method
	 * @param zoo from main
	 * @return 0 if no issues
	 */
	public static int listaakaikkielaimet(Zoo zoo){
		zoo.listAnimals();
		return 0;
	}

	/**
	 * Takes user input for how many laps to run
	 * @param zoo from main
	 * @return 0 if no issues
	 */
	public static int juoksutaelaimia(Zoo zoo){
		System.out.println("Kuinka monta kierrosta?");
		zoo.runAnimals(sc.nextInt());
		sc.nextLine();
		return 0;
	}

}