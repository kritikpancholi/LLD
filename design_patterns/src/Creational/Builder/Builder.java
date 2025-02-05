package Creational.Builder;

public abstract class Builder {

    public String door;
    public String window;
    public int floor;


    public Builder buildDoor(String door){
        this.door = door;
        return this;
    }
    public Builder buildWindows(String window){
        this.window = window;
        return  this;

    }
    public Builder buildFloors(int floors){
        this.floor = floors;
        return  this;
    }

    public abstract House build();
}
