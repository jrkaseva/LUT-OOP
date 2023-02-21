package main;

/**
 * Author: Joakim Kaseva
 * 21.2.2023
 * LUT - OOP course
 */
public class Plane extends Vehicle{
    private static final Engine engine = new Engine("Suihkumoottori", 500);

    /**
     * @param producer of plane
     * @param model of plane
     * @param top_speed of plane
     */
    public Plane(String producer, String model, int top_speed) {
        super(engine, producer, model, top_speed);
    }

    @Override
    public String toString() {
        return String.format("Lentokone: %s %s\n%s\nHuippunopeus: %dkm/h", producer, model, engine.toString(), top_speed);
    }

    /**
     * Fly the plane
     */
    public void fly(){
        String text = String.format("%s %s lentää kohteeseen!", producer, model);
        System.out.println(text);
    }

    /**
     * @param args none
     */
    public static void main(String[] args){
        Plane plane = new Plane("Airbus", "727", 750);
        System.out.println(plane);
    }
}
