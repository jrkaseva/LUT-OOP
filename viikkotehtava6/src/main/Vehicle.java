package main;

/**
 * Author: Joakim Kaseva
 * 21.2.2023
 * LUT - OOP course
 */
public class Vehicle {
    protected Engine engine;
    protected String producer;
    protected String model;
    protected int top_speed;
    
    /**
     * Default constructor
     */
    public Vehicle() {
        producer = "Kaseva";
        model = "Joakim";
        top_speed = 30;
    }

    /**
     * Constructor without engine
     * @param producer producer
     * @param model model
     * @param top_speed top speed
     */
    public Vehicle(String producer, String model, int top_speed) {
        this.producer = producer;
        this.model = model;
        this.top_speed = top_speed;
    }

    /**
     * Constructor with all attributes
     * @param engine engine
     * @param producer producer
     * @param model model
     * @param top_speed top speed
     */
    public Vehicle(Engine engine, String producer, String model, int top_speed) {
        this.engine = engine;
        this.producer = producer;
        this.model = model;
        this.top_speed = top_speed;
    }
    
}
