package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Joakim Kaseva
 * 21.2.2023
 * LUT - OOP course
 */
public class App {
	/**
	 * Scanner for user input
	 */
	public static final Scanner sc = new Scanner(System.in);

	/**
	 * Start program of vehicles
	 * @param args none
	 */
	public static void main(String[] args){
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		System.out.println("");
		int choice = menu();
		while (true){
			if (choice == 0) break;
			execute(choice, vehicles);
			choice = menu();
		}
		System.out.println("Kiitos ohjelman käytöstä.");
	}

	/**
	 * Prints the menu options
	 * @return choice of user to execute
	 */
	public static int menu(){
		String[] options = new String[] {"Luo uusi kulkuneuvo", "Listaa kulkuneuvot", "Aja autoja", "Lennä lentokoneita", "Seilaa laivoja"};
		for (int i = 1; i < options.length + 1; i++){
			if (i == 2) {
				System.out.print(String.format("%d) %s ", i, options[i - 1]));
				continue;
			}
			System.out.print(String.format("%d) %s, ", i, options[i - 1]));
		}
		System.out.println("0) Lopeta ohjelma");
		try {
			int choice = sc.nextInt();
			sc.nextLine();
			return choice;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Decides on which action to preform based on user input
	 * @param number user's choice
	 * @param vehicels contains vehicles
	 */
	public static void execute(int number, ArrayList<Vehicle> vehicles){
		if (number == 1){
			luouusikulkuneuvo(vehicles);
		}
		else if (number == 2){
			listaakulkuneuvot(vehicles);
		}
		else if (number == 3){
			ajaautoja(vehicles);
		}
		else if (number == 4){
			lennalentokoneita(vehicles);
		}
		else if (number == 5){
			seilaalaivoja(vehicles);
		}
		else System.out.println("Valintaa ei tunnistettu, yritä uudestaan.");
	}

	/**
	 * Takes user input and calls a constructor based on choice
	 * @param vehicels from main (contains vehicles)
	 */
	public static int luouusikulkuneuvo(ArrayList<Vehicle> vehicles){
		System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("Anna kulkuneuvon valmistaja:");
		String prod = sc.nextLine();
		System.out.println("Anna kulkuneuvon malli:");
		String mod = sc.nextLine();
		System.out.println("Anna kulkuneuvon huippunopeus:");
		int ts = sc.nextInt();
		sc.nextLine();
		switch (choice){
			case 1:
				vehicles.add(new Car(prod, mod, ts));
				break;
			case 2:
				vehicles.add(new Plane(prod, mod, ts));
				break;
			case 3:
				vehicles.add(new Ship(prod, mod, ts));
				break;
			default:
				System.out.println("Virhe valinnassa \"Luo uusi kulkuneuvo\"");
		}
		return 0;
	}

	/**
	 * Prints all vehicles
	 * @param vehicles from main (ccontains vehicles)
	 */
	public static void listaakulkuneuvot(ArrayList<Vehicle> vehicles){
		for (Vehicle v : vehicles){
			System.out.println(v + "\n");
		}
	}

	/**
	 * Calls Car.drive() for every Car-object
	 * @param vehicles from main (contains vehicles)
	 */
	public static void ajaautoja(ArrayList<Vehicle> vehicles){
		for (Vehicle v : vehicles){
			if (v instanceof Car) {
				Car c = (Car) v;
				c.drive();
			}
		}
	}

	/**
	 * Calls Plane.fly() for every Plane-object
	 * @param vehicles from main (contains vehicles)
	 */
	public static void lennalentokoneita(ArrayList<Vehicle> vehicles){
		for (Vehicle v : vehicles){
			if (v instanceof Plane) {
				Plane p = (Plane) v;
				p.fly();
			}
		}
	}

	/**
	 * Calls Ship.sail() for every Ship-object
	 * @param vehicles from main (contains vehicles)
	 */
	public static void seilaalaivoja(ArrayList<Vehicle> vehicles){
		for (Vehicle v : vehicles){
			if (v instanceof Ship) {
				Ship s = (Ship) v;
				s.sail();
			}
		}
	}
}