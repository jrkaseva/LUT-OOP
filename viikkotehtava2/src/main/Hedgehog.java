package main;

/**
 * Author: Joakim Kaseva
 * Hedgehog-class
 */

public class Hedgehog {
    private String name;
    private int age;
    
    /**
     * Main method
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("Ran Hedgehog class");
    }

    /**
     * Default constructor method - creates a hedgehog
     */
    public Hedgehog(){
        name = "Pikseli";
        age = 5;
    }

    /**
     * Constructor method with input
     * @param new_name input name
     * @param new_age input age
     */
    public Hedgehog(String new_name, int new_age){
        name = new_name;
        age = new_age;
    }

    /**
     * Prints the name and input
     * @param text input
     */
    public void speak(String text){
        if (text.length() == 0){
            System.out.println(String.format("Olen %s ja ikäni on %d vuotta, mutta antaisitko silti syötteen?", name, age));
        }
        else System.out.println(name + ": " + text);
    }

    /**
     * Replaces the hedgehogs information
     * @param new_name replaces current name
     * @param new_age replaces current age
     * @return
     */
    public void respecify(String new_name, int new_age){
        name = new_name;
        age = new_age;
    }

    /**
     * Prints a text n-amount of times.
     * @param laps_to_run
     */
    public void run(int laps_to_run){
        while(laps_to_run > 0){
            System.out.println(String.format("%s juoksee kovaa vauhtia!", name));
            laps_to_run--;
        }
    }
}
