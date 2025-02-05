package Creational.Builder;

public class House {

    private String door;
    private String window;
    private int floor;


    public House(Builder builder){
        this.door = builder.door;
        this.window = builder.window;
        this.floor = builder.floor;
    }

    @Override
    public String toString() {
        return "door = " +  door + " window = " + window + " floor = " + floor;
    }
}
