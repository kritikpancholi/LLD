package Creational.Builder;

public class BuilderDriver {

    public void build(){
    Director directorOne = new Director( new House1Builder());
    Director directorTwo = new Director(new House2Builder());

    House houseWithOneFloor = directorOne.createHouse();
    House getHouseWithTwoFloor = directorTwo.createHouse();

    System.out.println(houseWithOneFloor.toString());
    System.out.println(getHouseWithTwoFloor.toString());

    }
}
