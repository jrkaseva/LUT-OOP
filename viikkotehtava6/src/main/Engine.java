package main;

/**
 * Author: Joakim Kaseva
 * 21.2.2023
 * LUT - OOP course
 */
public class Engine {
    private String name;
    private int power;

    /**
     * Constructor with parametres
     * @param name of engine
     * @param power of engine
     */
    public Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }

    /**
     * Default constructor
     */
    public Engine() {
        name = "Kaseva Moottori";
        power = 1;
    }

    /**
     * @return Information of engine
     */
    @Override
    public String toString() {
        return "Moottori: " + name + " " + power + "kW";
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for power
     * @return power
     */
    public int getPower() {
        return power;
    }

    /**
     * Setter for power
     * @param power to be set
     */
    public void setPower(int power) {
        this.power = power;
    }
    
}
