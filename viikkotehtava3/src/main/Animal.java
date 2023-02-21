package main;

/**
 * LUT OOP -course
 * Animal class
 * Author: Joakim Kaseva
 * Last modified: 1.2.2023
 */
public class Animal {
    private String specie = "ihminen";
    private String name = "Joakim";
    private int age = 23;

    /**
     * Default constructor
     */
    public Animal(){}

    /**
     * Constructor with parametres
     * @param specie name
     * @param name of animal
     * @param age of animal
     */
    public Animal(String specie, String name, int age){
        this.specie = specie;
        this.name = name;
        this.age = age;
    }

    /**
     * get method for name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * get method for age
     * @return age
     */
    public int getAge(){
        return age;
    }

    /**
     * get method for specie
     * @return specie
     */
    public String getSpecie(){
        return specie;
    }
}
