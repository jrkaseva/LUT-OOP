package main;

/**
 * Author: Joakim Kaseva
 * 21.2.2023
 * LUT - OOP course
 */
public class Ship extends Vehicle {
    private static final Engine engine = new Engine("Wärtsilä Super", 1000);

    /**
     * Constructor with parametres
     * @param producer of ship
     * @param model of ship
     * @param top_speed of ship
     */
    public Ship(String producer, String model, int top_speed) {
        super(engine, producer, model, top_speed);
    }

    @Override
    public String toString() {
        return String.format("Laiva: %s %s\n%s\nHuippunopeus: %dkm/h", producer, model, engine.toString(), top_speed);
    }

    /**
     * Sail the ship
     */
    public void sail(){
        String text = String.format("%s %s seilaa merten ääriin!", producer, model);
        System.out.println(text);
    }

    /**
     * @param args none
     */
    public static void main(String[] args){
        Ship ship = new Ship("Tallink Silja", "Baltic Princess", 60);
        System.out.println(ship);
    }
}
