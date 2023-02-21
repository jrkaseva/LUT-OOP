package main;

import java.util.Scanner;

/*
 * Author: Joakim Kaseva
 * VT 2 - LUT Olio-ohjelmointi kurssi
 */
public class App {
    /**
     * Main program which holds the menu and actions
     * @param args none
     */
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Hedgehog hedgehog = new Hedgehog();
        int choice = menu();
        while (true){
            if (choice == 0){
                break;
            }
            execute(choice, hedgehog);
            choice = menu();
        }
        System.out.println("Kiitos ohjelman käytöstä.");
    }

    /**
     * Creates the menu
     * @return the choice of the user
     */
    public static int menu(){
        int choice = 99;
        System.out.println("1) Pistä siili puhumaan, 2) Luo uusi siili, 3) Juoksuta siiliä, 0) Lopeta ohjelma");
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Virhe: Et antanut kokonaislukua");
        }
        return choice;
    }

    /**
     * Determines which action is done based on user input
     * @param number users choice
     * @param hedgehog from main-method that is used in actions
     */
    public static void execute(int number, Hedgehog hedgehog){
        switch (number){
            case 1:
                talk(hedgehog);
                break;
            case 2:
                create(hedgehog);
                break;
            case 3:
                run(hedgehog);
                break;
            default:
                System.out.println("Syöte oli väärä");
        }
    }

    /**
     * Takes user input and gives it to the hedgehog
     * @param hedgehog from main-method that is used in actions
     */
    public static void talk(Hedgehog hedgehog){
        System.out.println("Mitä siili sanoo:");
        String text = sc.nextLine();
        hedgehog.speak(text);
    }

    /**
     * Takes user input and gives it to the hedgehog
     * @param hedgehog from main-method that is used in actions
     */
    public static void create(Hedgehog hedgehog){
        System.out.println("Anna siilin nimi:");
        String new_name = sc.nextLine();
        System.out.println("Anna siilin ikä:");
        try {
            int new_age = sc.nextInt();
            sc.nextLine();
            hedgehog.respecify(new_name, new_age);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Virhe: Et antanut kokonaislukua");
        }
    }

    /**
     * Takes user input and gives it to the hedgehog
     * @param hedgehog from main-method that is used in actions
     */
    public static void run(Hedgehog hedgehog){
        System.out.println("Kuinka monta kierrosta?");
        try {
            int laps = sc.nextInt();
            sc.nextLine();
            hedgehog.run(laps);
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Virhe: Et antanut kokonaislukua");
        }
    }
}