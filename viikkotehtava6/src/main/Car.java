package main;

/**
 * Author: Joakim Kaseva
 * 21.2.2023
 * LUT - OOP course
 */
public class Car extends Vehicle {
    private static final Engine engine = new Engine("V8", 300);

    /**
     * @param producer of car
     * @param model of car
     * @param top_speed of car
     */
    public Car(String producer, String model, int top_speed) {
        super(engine, producer, model, top_speed);
    }

    @Override
    public String toString() {
        return String.format("Auto: %s %s\n%s\nHuippunopeus: %dkm/h", producer, model, engine.toString(), top_speed);
    }
    
    /**
     * Drive the car
     */
    public void drive(){
        String text = String.format("%s %s paahtaa tietä eteenpäin!", producer, model);
        System.out.println(text);
    }

    /**
     * @param args none
     */
    public static void main(String[] args){
        Car car = new Car("Audi", "R8", 260);
        System.out.println(car);
    }
}
