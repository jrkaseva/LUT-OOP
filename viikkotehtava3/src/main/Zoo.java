package main;

import java.util.ArrayList;

/**
 * LUT OOP-course
 * Zoo class. Zoo can contain animals and have them listed and run around.
 * Author: Joakim Kaseva
 * Last modified: 1.2.2023
 */
public class Zoo {
    String name = "Ähtäri";
    ArrayList<Animal> animals = new ArrayList<Animal>();

    /**
     * The default constructor
     */
    public Zoo(){}

    /**
     * Constructor with parameters
     * @param name of the zoo
     */
    public Zoo(String name){
        this.name = name;
    }

    /**
     * Adds a new animal to the zoo
     * @param new_animal to add
     * @return 0 if no issues
     */
    public int addAnimal(Animal new_animal){
        animals.add(new_animal);
        return 0;
    }

    /**
     * Lists all animals and their information
     * @return 0 if no issues
     */
    public int listAnimals(){
        System.out.println(String.format("%s pitää sisällään seuraavat eläimet:", name));
        for (Animal resident : animals) {
            System.out.println(String.format("%s: %s, %d vuotta", resident.getSpecie(), resident.getName(), resident.getAge()));
        }
        return 0;
    }

    /**
     * Has the zoo's animals run around
     * @param laps to run
     */
    public void runAnimals(int laps){
        for (Animal resident : animals) {
            for (int i = 0; i < laps; i++){
                System.out.println(String.format("%s juoksee kovaa vauhtia!", resident.getName()));
            }
        }
    }
}
